package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.AddressEntity;
import com.zzbslayer.bookstore.datamodel.dao.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressEntity> findAll(){ return addressRepository.findAll();}
    public List<AddressEntity> findByUsername(String username){
        return addressRepository.findByUsername(username);
    }

    public void deleteAddress(Integer addressid){
        AddressEntity addr = addressRepository.findByAddressid(addressid);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals(addr.getUsername()))
            addressRepository.delete(addr);
    }

    public AddressEntity updateAddress(AddressEntity addr){
        AddressEntity address = addressRepository.findByAddressid(addr.getAddressid());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals(address.getUsername())){
            addr.setUsername(username);
            return addressRepository.save(addr);
        }
        return null;
    }

    public AddressEntity save (AddressEntity addr){
        AddressEntity add =  addressRepository.save(addr);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return addressRepository.findByUsernameAndShippingaddressAndRecipientAndPhone(name,add.getShippingaddress(),add.getRecipient(),add.getPhone());
    }
}
