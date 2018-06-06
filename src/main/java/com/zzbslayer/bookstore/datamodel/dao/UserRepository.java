package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer > {

    List<UserEntity>findAll();

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
