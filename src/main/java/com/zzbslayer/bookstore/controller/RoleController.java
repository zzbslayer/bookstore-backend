package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value="/roles")
    @ResponseBody
    public JSONArray findAll(){
        List<RoleEntity> roles = roleService.findAll();
        System.out.println(JSONArray.fromObject(roles));
        return JSONArray.fromObject(roles);
    }

    @RequestMapping(value="/roles/by/email/{email}")
    @ResponseBody
    public JSONObject findByUsername(@PathVariable String username) {
        RoleEntity role = roleService.findByUsername(username);
        return JSONObject.fromObject(role);
    }

    @RequestMapping(value="/roles/by/rolename/{rolename}")
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
