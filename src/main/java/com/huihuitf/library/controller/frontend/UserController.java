package com.huihuitf.library.controller.frontend;

import com.huihuitf.library.dto.UserExecution;
import com.huihuitf.library.enums.UserStateEnum;
import com.huihuitf.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param cardId 卡号
     * @param password 密码
     * @return json 用于前端判断是否成功登陆
     */
    @GetMapping("/verifylogin")
    public ModelMap userLogin(@RequestParam(value = "cardNumber") Long cardId, @RequestParam(value = "password") String password){
        ModelMap modelMap=new ModelMap();
        if(cardId==null || password==null){
            modelMap.addAttribute("success",false);
            modelMap.addAttribute("msg","卡号和密码不能为空");
            return modelMap;
        }
        try {
            UserExecution userExecution = userService.queryUserById(cardId);
            // 用户名和密码匹配时才可以登陆
            if (userExecution.getState() == UserStateEnum.SUCCESS.getState()
                    && userExecution.getUser().getPassword().equals(password)) {
               modelMap.addAttribute("success",true);
               HttpSession session = request.getSession();
               if(session.getAttribute("cardId")==null){
                   session.setAttribute("cardId",cardId);
               }
            }else{
                modelMap.addAttribute("success",false);
                modelMap.addAttribute("msg","卡号或密码不正确");
            }
        }catch (Exception e){
            modelMap.addAttribute("success",false);
            modelMap.addAttribute("msg","未知错误！");
        }
        return modelMap;
    }
}
