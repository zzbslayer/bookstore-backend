package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.RegisterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping(value="/register")
    @ResponseBody
    public JSONObject save(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("email")String email, @RequestParam("phone")String phone){
        UserEntity newuser = registerService.register(username,password,email,phone);
        return JSONObject.fromObject(newuser);
    }
}
