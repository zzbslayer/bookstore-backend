package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.model.UserStatusEntity;
import com.zzbslayer.bookstore.service.AdminService;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value="/admin/userstatus")
    @ResponseBody
    public JSONArray findAll(){
        List<UserStatusEntity> userstatus = adminService.findStatusAll();
        System.out.println(JSONArray.fromObject(userstatus));
        return JSONArray.fromObject(userstatus);
    }

    @GetMapping(value="/admin/userstatus/{username}")
    @ResponseBody
    public JSONObject findStatusByUsername(@PathVariable String username) {
        UserStatusEntity user = adminService.findStatusByUsername(username);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/admin/users/username/{username}")
    @ResponseBody
    public JSONObject findUserByUsername(@PathVariable String username){
        UserEntity user = adminService.findUserByUsername(username);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/admin/users/email/{email}")
    @ResponseBody
    public JSONObject findUserByEmail(@PathVariable String email){
        UserEntity user = adminService.findUserByEmail(email);
        return JSONObject.fromObject(user);
    }

    /*
    @RequestMapping("saveUserStatusEntity")
    @ResponseBody
    public void saveUserStatusEntity() {
        UserStatusEntity u = new UserStatusEntity();
        u.setUserStatusname("Evan_song");
        u.setPw("xixixi");
        u.setEmail("evansong@sjtu.edu.cn");
        u.setPhone("18033245325");
        u.setPermission("user");
        userRepository.save(u);
    }
    */
}