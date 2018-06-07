package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/user/profile")
public class UserProfileController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    @ResponseBody
    public JSONObject getProfile() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userService.findByUsername(name);
        return JSONObject.fromObject(user);
    }

    @PostMapping(value="/update")
    @ResponseBody
    public JSONObject updateInfo(@RequestParam("email")String email, @RequestParam("phone") String phone, @RequestParam("avatar") String avatar){
        UserEntity user = new UserEntity();
        System.out.println(avatar);
        user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar(avatar);
        return JSONObject.fromObject(userService.updateInfo(user));
    }
}
