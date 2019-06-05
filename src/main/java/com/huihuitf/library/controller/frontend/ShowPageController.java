package com.huihuitf.library.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend")
public class ShowPageController {
    @GetMapping("/login")
    public String login(){
        return "html/user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "html/user/register";
    }
}
