package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.UserStatusEntity;
import com.zzbslayer.bookstore.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusService {
    @Autowired
    private UserStatusRepository userStatusRepository;

    public List<UserStatusEntity> findAll(){
        return userStatusRepository.findAll();
    }

    public UserStatusEntity findByUsername(String username){
        return userStatusRepository.findByUsername(username);
    }
}