package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface AddressRepository extends MongoRepository<Address, BigInteger>{
    Address findByUsername(String username);
}
