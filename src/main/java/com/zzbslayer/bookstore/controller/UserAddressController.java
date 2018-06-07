package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.Address;
import com.zzbslayer.bookstore.service.AddressService;
import com.zzbslayer.bookstore.utils.AddressRow;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/user/address")
public class UserAddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping(value="/")
    @ResponseBody
    public JSONObject getAddress(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Address address = addressService.findByUsername(name);
        return JSONObject.fromObject(address);
    }

    @PostMapping(value="/add")
    @ResponseBody
    public JSONObject addAddress(@RequestParam("shippingaddress")String shippingaddress,@RequestParam("recipient")String recipient,@RequestParam("phone")String phone){
        AddressRow addr = new AddressRow();
        addr.setAddressid(0);
        addr.setShippingaddress(shippingaddress);
        addr.setRecipient(recipient);
        addr.setPhone(phone);
        return JSONObject.fromObject(addressService.save(addr));
    }

    @PostMapping(value="/update")
    @ResponseBody
    public JSONObject updateAddress(@RequestParam("addressid")Integer addressid,@RequestParam("shippingaddress")String shippingaddress,@RequestParam("recipient")String recipient,@RequestParam("phone")String phone){
        AddressRow addr = new AddressRow();
        addr.setAddressid(addressid);
        addr.setShippingaddress(shippingaddress);
        addr.setRecipient(recipient);
        addr.setPhone(phone);
        return JSONObject.fromObject(addressService.updateAddress(addr));
    }


    @PostMapping(value="/delete")
    @ResponseBody
    public JSONArray deleteAddress(@RequestParam("addressid")Integer addressid){
        return JSONArray.fromObject(addressService.deleteAddress(addressid));
    }
}
