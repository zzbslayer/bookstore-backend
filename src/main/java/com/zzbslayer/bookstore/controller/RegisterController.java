package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.NaiveError;
import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.service.RegisterService;
import com.zzbslayer.bookstore.service.RoleService;
import com.zzbslayer.bookstore.service.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        if (newuser == null)
            return JSONObject.fromObject(new NaiveError("Register Error","User Existed"));
        return JSONObject.fromObject(newuser);
    }
}
