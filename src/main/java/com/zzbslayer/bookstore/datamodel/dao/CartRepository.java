package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface CartRepository extends MongoRepository<Cart, BigInteger> {
    Cart findByUsername(String username);
}
