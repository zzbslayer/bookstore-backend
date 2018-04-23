package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.AddressEntity;
import com.zzbslayer.bookstore.model.BookinCart;
import com.zzbslayer.bookstore.model.CartEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.service.AddressService;
import com.zzbslayer.bookstore.service.CartService;
import com.zzbslayer.bookstore.service.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import net.sf.json.JSONObject;

import java.util.List;


@RestController
@RequestMapping(value="/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/user/profile")
    @ResponseBody
    public JSONObject getProfile() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userService.findByUsername(name);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/user/address")
    @ResponseBody
    public JSONArray getAddress(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<AddressEntity> addresses = addressService.findByUsername(name);
        return JSONArray.fromObject(addresses);
    }

    @GetMapping(value="/user/cart")
    @ResponseBody
    public JSONArray getCart(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<BookinCart> cart = cartService.findByUsername(name);
        return JSONArray.fromObject(cart);
    }

    @PostMapping(value="/user/update")
    @ResponseBody
    public JSONObject updateInfo(@RequestParam("email")String email, @RequestParam("phone") String phone){
        UserEntity user = new UserEntity();
        user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        user.setPhone(phone);
        return JSONObject.fromObject(userService.updateInfo(user));
    }

    @PostMapping(value="/user/cart/delete")
    @ResponseBody
    public void deleteCart(@RequestParam("cartid")Integer cartid){
        cartService.deleteByCartid(cartid);
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
