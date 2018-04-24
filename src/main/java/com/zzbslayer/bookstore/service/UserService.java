package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.NaiveError;
import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.model.UserStatusEntity;
import com.zzbslayer.bookstore.repository.RoleRepository;
import com.zzbslayer.bookstore.repository.UserRepository;
import com.zzbslayer.bookstore.repository.UserStatusRepository;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateInfo(UserEntity user){
        UserEntity toupdate = userRepository.findByUsername(user.getUsername());
        toupdate.setEmail(user.getEmail());
        toupdate.setPhone(user.getPhone());
        return userRepository.save(toupdate);
    }
}
