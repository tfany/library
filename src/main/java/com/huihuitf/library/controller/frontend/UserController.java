package com.huihuitf.library.controller.frontend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * @param cardId   卡号
     * @param password 密码
     * @return json 用于前端判断是否成功登陆
     */
    @PostMapping("/verifylogin")
    public ModelMap userLogin(@RequestParam(value = "cardNumber", required = false) Long cardId, @RequestParam(value = "password", required = false) String password) {
        ModelMap modelMap = new ModelMap();
        if (cardId == null || password == null) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "卡号和密码不能为空");
            return modelMap;
        }
        try {
            // 用户名存在且密码匹配时才可以登陆
            if (userService.passwordIsTrue(cardId,password)) {

                //设置session信息
                HttpSession session = request.getSession();
                if (session.getAttribute("user") == null) {
                    session.setAttribute("user", userService.queryUser(new User(cardId)).get(0));
                }
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("msg", "用户不存在或密码不正确");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "服务器繁忙，请稍后再试！");
            return modelMap;
        }
        modelMap.addAttribute("success", true);
        return modelMap;
    }

    @PostMapping("/verifyregister")
    public ModelMap userRegister(@RequestParam(value="headImg",required = false)MultipartFile headImg) {

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
        User tempUser=new User();
        tempUser.setPhoneNum(user.getPhoneNum());
        if(userService.queryUser(tempUser).size()!=0){
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "手机号已存在！");
            return modelMap;
        }

        //2.注册

        if (headImg != null) {
           userService.addUser(user, headImg);
        }
        else{
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("msg", "图片上传失败");
            return modelMap;
        }
        modelMap.addAttribute("success",true);
        modelMap.addAttribute("userId",user.getUserId());
        return modelMap;
    }
}
