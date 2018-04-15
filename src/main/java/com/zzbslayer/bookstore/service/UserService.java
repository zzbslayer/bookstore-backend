package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
