package com.zzbslayer.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/login_page")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
