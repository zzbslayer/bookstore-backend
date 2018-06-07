package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, BigInteger>{
    List<Order> findByUsername(String username);
}
