package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.AddressEntity;

import java.util.List;

public interface AddressService {

    List<AddressEntity> findAll();

    List<AddressEntity> findByUsername(String username);

    void deleteAddress(Integer addressid);

    AddressEntity updateAddress(AddressEntity addr);

    AddressEntity save (AddressEntity addr);
}
