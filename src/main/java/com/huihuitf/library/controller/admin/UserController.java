package com.huihuitf.library.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.dto.UserDto;
import com.huihuitf.library.entity.Rank;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import com.huihuitf.library.util.PageHelp;
import com.huihuitf.library.util.PathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    /**
     * 验证用户登陆
     *
     * @return json 用于前端判断是否成功登陆
     */
    @PostMapping("/verifylogin")
    //@ResponseBody
    public CommonResult userLogin(@RequestBody User user) {


        ModelMap modelMap = new ModelMap();
        Long cardId = user.getUserId();
        String password = user.getPassword();

        Map<String, String> tokenMap = new HashMap<>();

        try {
            // 用户名存在且密码匹配时才可以登陆
            if (userService.passwordIsTrue(cardId, password)) {
                tokenMap.put("token", String.valueOf(cardId));
                return CommonResult.success(tokenMap);
            }
            return CommonResult.failed();
        } catch (Exception e) {
            return CommonResult.failed("密码错误！");
        }
    }

    /**
     * 获取信息
     * @return
     */
    @GetMapping("/userinfo")
    public CommonResult userInfo() {
        String token = request.getHeader("token");
        User user = new User();
        if (token != null) {
            if (token.length() == 11) {
                user.setPhoneNum(token);
            } else {
                user.setUserId(Long.valueOf(token));
            }
            user = userService.queryUser(user).get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("username", user.getName());
            data.put("roles", new String[]{"Manager"});
            data.put("icon", user.getHeadImg());
            return CommonResult.success(data);
        }


        return CommonResult.failed();
    }

    @GetMapping("/list")
    public CommonResult list(int pageNum,int pageSize) {

        Map<String, Object> map=new HashMap<>();
        PageHelp.pageDeal(pageNum, pageSize, userService.queryTotal(),map);
        map.put("list", userService.listUser(pageNum - 1, pageSize));
        return CommonResult.success(map);
    }

    @GetMapping("/updateInfo/{id}")
    public CommonResult list(@PathVariable Long id) {
        User user = new User();
        if(String.valueOf(id).length()==5){
            user.setUserId(id);
        }else {
            user.setPhoneNum(String.valueOf(id));
        }
        if(userService.queryUser(user).size()>0){
            User user1 = userService.queryUser(user).get(0);
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user1,userDto);
            userDto.setLevel(user1.getRank().getLevel());
            return CommonResult.success(userDto);
        }
        return CommonResult.failed("修改失败");
    }

    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,@RequestBody UserDto userDto) {
       if(!id.equals(userDto.getUserId())){
           return CommonResult.failed("不要改导航栏!!");
       }
       User user=new User();
       BeanUtils.copyProperties(userDto,user);
       if(userDto.getLevel()!=null){
           Rank rank = new Rank();
           rank.setLevel(userDto.getLevel());
           user.setRank(rank);
       }
       if(userService.modifyInformation(user)==1){
           if(user.getHeadImg()!=null){
               PathUtil.deleteFiles(user.getHeadImg());
           }
           return CommonResult.success(null);
       }

       return CommonResult.failed("修改失败");
    }

    @PostMapping("/update/deleteStatus")
    public CommonResult delete(Long id) {

        userService.deleteUser(id);
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
    @ResponseBody

    public CommonResult upload(@PathVariable Long id, @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            String imgUrl = userService.addFace(id, file);

            return CommonResult.success(imgUrl);

        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    /**
     * 退出登录
     * @return success
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    /**
     * 注册
     * @param headImg
     * @return
     */
    @PostMapping("/verifyregister")
    public ModelMap userRegister(@RequestParam(value = "headImg", required = false) MultipartFile headImg) {

        ModelMap modelMap = new ModelMap();
        //1.接收并转换相应的参数 包括用户信息以及头像信息

        // 接收并转换相应的参数
        ObjectMapper mapper = new ObjectMapper();
        User user;
        String userInfo = request.getParameter("userInfo");
        try {
            user = mapper.readValue(userInfo, User.class);
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "违法操作！");
            return modelMap;
        }

        //判断手机号是否存在
        User tempUser = new User();
        tempUser.setPhoneNum(user.getPhoneNum());
        if (userService.queryUser(tempUser).size() != 0) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "手机号已存在！");
            return modelMap;
        }

        //2.注册

        if (headImg != null) {
            userService.addUser(user, headImg);
        } else {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "图片上传失败");
            return modelMap;
        }
        modelMap.addAttribute("success", true);
        modelMap.addAttribute("userId", user.getUserId());
        return modelMap;
    }
}
