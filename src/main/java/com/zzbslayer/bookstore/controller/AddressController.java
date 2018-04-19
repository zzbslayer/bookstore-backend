package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.AddressEntity;
import com.zzbslayer.bookstore.service.AddressService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping(value="/addresses")
    @ResponseBody
    public JSONArray findAll(){
        List<AddressEntity> addresses = addressService.findAll();
        return JSONArray.fromObject(addresses);
    }

    @GetMapping(value="/addresses/username/{username}")
    @ResponseBody
    public JSONArray findByUsername(@PathVariable String username){
        List<AddressEntity> addresses = addressService.findByUsername(username);
        return JSONArray.fromObject(addresses);
    }
}
