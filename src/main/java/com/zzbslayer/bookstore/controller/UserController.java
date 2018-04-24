package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.*;
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
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/profile")
    @ResponseBody
    public JSONObject getProfile() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userService.findByUsername(name);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/address")
    @ResponseBody
    public JSONArray getAddress(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<AddressEntity> addresses = addressService.findByUsername(name);
        return JSONArray.fromObject(addresses);
    }

    @PostMapping(value="/address/add")
    @ResponseBody
    public JSONObject addAddress(@RequestParam("shippingaddress")String shippingaddress,@RequestParam("recipient")String recipient,@RequestParam("phone")String phone){
        AddressEntity addr = new AddressEntity();
        addr.setAddressid(0);
        addr.setShippingaddress(shippingaddress);
        addr.setRecipient(recipient);
        addr.setPhone(phone);
        addr.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        addr = addressService.save(addr);
        return JSONObject.fromObject(addr);
    }

    @PostMapping(value="/address/update")
    @ResponseBody
    public JSONObject updateAddress(@RequestParam("addressid")Integer addressid,@RequestParam("shippingaddress")String shippingaddress,@RequestParam("recipient")String recipient,@RequestParam("phone")String phone){
        AddressEntity addr = new AddressEntity();
        addr.setAddressid(addressid);
        addr.setShippingaddress(shippingaddress);
        addr.setRecipient(recipient);
        addr.setPhone(phone);
        addr = addressService.updateAddress(addr);
        if (addr == null)
            return JSONObject.fromObject(new NaiveError("Edit Address Error","Address Not Matched"));
        return JSONObject.fromObject(addr);
    }


    @PostMapping(value="/address/delete")
    @ResponseBody
    public void deleteAddress(@RequestParam("addressid")Integer addressid){
        addressService.deleteAddress(addressid);
    }

    @GetMapping(value="/cart")
    @ResponseBody
    public JSONArray getCart(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<BookinCart> cart = cartService.findByUsername(name);
        return JSONArray.fromObject(cart);
    }

    @PostMapping(value="/profile/update")
    @ResponseBody
    public JSONObject updateInfo(@RequestParam("email")String email, @RequestParam("phone") String phone){
        UserEntity user = new UserEntity();
        user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setEmail(email);
        user.setPhone(phone);
        return JSONObject.fromObject(userService.updateInfo(user));
    }

    @PostMapping(value="/cart/delete")
    @ResponseBody
    public void deleteCart(@RequestParam("cartid")Integer cartid){
        cartService.deleteByCartid(cartid);
    }

    @PostMapping(value="/cart/add")
    @ResponseBody
    public JSONObject addToCart(@RequestParam("bookid")Integer bookid, @RequestParam("count")Integer count){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return JSONObject.fromObject(cartService.addToCart(bookid, count, name));
    }

    @PostMapping(value="/cart/edit")
    @ResponseBody
    public JSONObject editCart(@RequestParam("bookid")Integer bookid, @RequestParam("count")Integer count){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        CartEntity cart = cartService.editCart(name, bookid, count);
        if (cart == null){
            return JSONObject.fromObject(new NaiveError("Edit Cart Error","Cart Not Exist"));
        }
        return JSONObject.fromObject(cart);
    }

    @GetMapping(value="/username")
    @ResponseBody
    public String getUsername(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }

    @GetMapping(value="/role")
    @ResponseBody
    public JSONArray getRole(){
        return JSONArray.fromObject(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

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
