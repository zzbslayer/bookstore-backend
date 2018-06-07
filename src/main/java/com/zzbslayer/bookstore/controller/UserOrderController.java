package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.Order;
import com.zzbslayer.bookstore.service.OrderService;
import com.zzbslayer.bookstore.utils.AddressRow;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/user/order")
public class UserOrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value="/")
    @ResponseBody
    public JSONArray getOrder(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Order> orderlist = orderService.findOrderByUsername(name);
        return JSONArray.fromObject(orderlist);
    }

    @PostMapping(value="/add")
    @ResponseBody
    public JSONObject addOrder(@RequestParam("book") List<String> books, @RequestParam("shippingaddress")String shippingaddress, @RequestParam("recipient")String recipient, @RequestParam("phone")String phone){
        return JSONObject.fromObject(orderService.addOrder(books,shippingaddress, recipient, phone));
    }
}
