package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface AvatarRepository extends MongoRepository<Avatar, BigInteger> {
    Avatar findByUsername(String username);
}
