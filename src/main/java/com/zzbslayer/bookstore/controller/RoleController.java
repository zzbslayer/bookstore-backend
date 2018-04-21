package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

@RestController
@RequestMapping(value="/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/roles")
    @ResponseBody
    public JSONArray findAll(){
        List<RoleEntity> roles = roleService.findAll();
        System.out.println(JSONArray.fromObject(roles));
        return JSONArray.fromObject(roles);
    }

    @GetMapping(value="/roles/by/email/{email}")
    @ResponseBody
    public JSONArray findByUsername(@PathVariable String username) {
        List<RoleEntity> role = roleService.findByUsername(username);
        return JSONArray.fromObject(role);
    }

    @GetMapping(value="/roles/by/rolename/{rolename}")
    @ResponseBody
    public JSONArray findByRolename(@PathVariable String rolename) {
        List<RoleEntity> role = roleService.findByRolename(rolename);
        return JSONArray.fromObject(role);
    }

    /*
    @RequestMapping("saveRoleEntity")
    @ResponseBody
    public void saveRoleEntity() {
        RoleEntity u = new RoleEntity();
        u.setRolename("Evan_song");
        u.setPw("xixixi");
        u.setEmail("evansong@sjtu.edu.cn");
        u.setPhone("18033245325");
        u.setPermission("role");
        roleRepository.save(u);
    }
    */
}
