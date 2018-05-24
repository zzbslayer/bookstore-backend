package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll();

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

    UserEntity save(UserEntity user);

    UserEntity updateInfo(UserEntity user);
}
