package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.AddressEntity;
import com.zzbslayer.bookstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public List<AddressEntity> findByUsername(String username){
        return addressRepository.findByUsername(username);
    }
}
