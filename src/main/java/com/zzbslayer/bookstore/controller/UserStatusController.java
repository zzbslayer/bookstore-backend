package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.domain.UserStatusEntity;
import com.zzbslayer.bookstore.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.util.List;

@Controller
public class UserStatusController {

    @Autowired
    private UserStatusService userStatusService;

    @RequestMapping(value="/userstatus")
    @ResponseBody
    public JSONArray findAll(){
        List<UserStatusEntity> userstatus = userStatusService.findAll();
        System.out.println(JSONArray.fromObject(userstatus));
        return JSONArray.fromObject(userstatus);
    }

    @RequestMapping(value="/userstatus/{username}")
    @ResponseBody
    public JSONObject findByUsername(@PathVariable String username) {
        UserStatusEntity user = userStatusService.findByUsername(username);
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