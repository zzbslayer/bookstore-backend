package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.AddressEntity;
import com.zzbslayer.bookstore.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
