package com.huihuitf.library.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
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
            }
            return CommonResult.success(tokenMap);
        } catch (Exception e) {
            return CommonResult.failed();
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
                user.setPassword(token);
            } else {
                user.setUserId(Long.valueOf(token));
            }
            user = userService.queryUser(user).get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("username", user.getName());
            data.put("roles", new String[]{"TEST"});
            data.put("icon", user.getHeadImg());
            return CommonResult.success(data);
        }


        return CommonResult.failed();
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
