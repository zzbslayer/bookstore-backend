package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, Integer> {
    Cart findByUsername(String username);
}
