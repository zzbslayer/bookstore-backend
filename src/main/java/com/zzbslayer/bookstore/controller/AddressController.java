package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.AddressEntity;
import com.zzbslayer.bookstore.service.AddressService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value="addresses/username/{username}")
    @ResponseBody
    public JSONArray findByUsername(@PathVariable String username){
        List<AddressEntity> addresses = addressService.findByUsername(username);
        return JSONArray.fromObject(addresses);
    }
}
