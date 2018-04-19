package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.model.UserStatusEntity;
import com.zzbslayer.bookstore.repository.UserRepository;
import com.zzbslayer.bookstore.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserStatusRepository userStatusRepository;

    public List<UserStatusEntity> findStatusAll(){
        return userStatusRepository.findAll();
    }

    public UserStatusEntity findStatusByUsername(String username) {
        return userStatusRepository.findByUsername(username);
    }

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findUserAll(){
        return userRepository.findAll();
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
