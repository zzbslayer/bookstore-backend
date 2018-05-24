package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
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
        toupdate.setAvatar(user.getAvatar());
        return userRepository.save(toupdate);
    }
}
