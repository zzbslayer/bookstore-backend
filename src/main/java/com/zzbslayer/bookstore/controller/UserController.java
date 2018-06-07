package com.zzbslayer.bookstore.controller;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/user")
public class UserController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/username")
    @ResponseBody
    public String getUsername(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }

    @GetMapping(value="/role")
    @ResponseBody
    public JSONArray getRole(){
        return JSONArray.fromObject(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

    }
}
