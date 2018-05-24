package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.AddressEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<AddressEntity> findAll();

    List<AddressEntity> findByUsername(String username);

    void deleteAddress(Integer addressid);

    AddressEntity updateAddress(AddressEntity addr);

    AddressEntity save (AddressEntity addr);
}
