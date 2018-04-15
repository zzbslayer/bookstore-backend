package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/users")
    @ResponseBody
    public JSONArray findAll(){
        List<UserEntity> roles = userService.findAll();
        System.out.println(JSONArray.fromObject(roles));
        return JSONArray.fromObject(roles);
    }

    @RequestMapping(value="/users/by/email/{email}")
    @ResponseBody
    public JSONObject findByEmail(@PathVariable String email) {
        UserEntity user = userService.findByEmail(email);
        return JSONObject.fromObject(user);
    }

    @RequestMapping(value="/users/by/username/{username}")
    @ResponseBody
    public JSONObject findByUsername(@PathVariable String username) {
        UserEntity user = userService.findByUsername(username);
        return JSONObject.fromObject(user);
    }

    /*
    @RequestMapping("saveUserEntity")
    @ResponseBody
    public void saveUserEntity() {
        UserEntity u = new UserEntity();
        u.setUsername("Evan_song");
        u.setPw("xixixi");
        u.setEmail("evansong@sjtu.edu.cn");
        u.setPhone("18033245325");
        u.setPermission("user");
        userRepository.save(u);
    }
    */
}
