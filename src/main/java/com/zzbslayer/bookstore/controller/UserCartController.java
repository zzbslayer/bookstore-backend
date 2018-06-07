package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.Cart;
import com.zzbslayer.bookstore.service.CartService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/user/cart")
public class UserCartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value="/")
    @ResponseBody
    public JSONArray getCart(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<BookEntity> cart = cartService.findByUsername(name);
        return JSONArray.fromObject(cart);
    }

    @PostMapping(value="/delete")
    @ResponseBody
    public JSONArray deleteCartByBookid(@RequestParam("bookid")Integer bookid){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return JSONArray.fromObject(cartService.deleteByBookid(bookid, name));
    }


    @PostMapping(value="/save")
    @ResponseBody
    public JSONObject addCart(@RequestParam("bookid")Integer bookid, @RequestParam("count")Integer count){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return JSONObject.fromObject(cartService.addCart(bookid, count, name));
    }

    @PostMapping(value="/update")
    @ResponseBody
    public JSONObject editCart(@RequestParam("bookid")Integer bookid, @RequestParam("count")Integer count){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartService.editCart(name, bookid, count);
        return JSONObject.fromObject(cart);
    }
}
