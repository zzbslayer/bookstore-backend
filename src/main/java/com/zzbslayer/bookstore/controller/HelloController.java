package com.zzbslayer.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("first")
    public String first(Model model) {
        model.addAttribute("hello", "world");
        return "first";
    }


}
