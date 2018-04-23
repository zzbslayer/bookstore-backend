package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.NaiveError;
import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.service.RoleService;
import com.zzbslayer.bookstore.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value="/register")
    @ResponseBody
    public JSONObject save(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("email")String email, @RequestParam("phone")String phone){
        UserEntity user = new UserEntity();
        user.setUserid(0);
        user.setUsername(username);
        user.setPw(password);
        user.setEmail(email);
        user.setPhone(phone);

        RoleEntity role = new RoleEntity();
        role.setRoleid(0);
        role.setRolename("USER");
        role.setUsername(user.getUsername());
        try {
            UserEntity newUser = userService.save(user);
            roleService.save(role);
            return JSONObject.fromObject(newUser);
        }
        catch(Exception e){
            logger.debug("Register Error:"+e.getMessage());
            return JSONObject.fromObject(new NaiveError("Registration","Resgistration failed"));
        }
    }
}
