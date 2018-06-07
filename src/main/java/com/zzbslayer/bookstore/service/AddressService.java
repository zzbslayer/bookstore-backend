package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.Address;
import com.zzbslayer.bookstore.utils.AddressRow;

public interface AddressService {

    Address findByUsername(String username);

    Address deleteAddress(Integer addressid);

    Address updateAddress(AddressRow addr);

    Address save (AddressRow addr);
}
