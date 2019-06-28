package com.huihuitf.library.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/frontend")
public class ShowPageController {
    @GetMapping("/login")
    public String login(HttpServletResponse response){
        Cookie cookie=new Cookie("token",String.valueOf("cookie"));
        response.addCookie(cookie);
        return "html/user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "html/user/register";
    }
}
