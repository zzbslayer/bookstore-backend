package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.model.UserStatusEntity;
import com.zzbslayer.bookstore.repository.RoleRepository;
import com.zzbslayer.bookstore.repository.UserRepository;
import com.zzbslayer.bookstore.repository.UserStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    public UserEntity register(String username, String password, String email, String phone){
        UserEntity user = new UserEntity();
        user.setUserid(0);
        user.setUsername(username);
        user.setPw(password);
        user.setEmail(email);
        user.setPhone(phone);

        RoleEntity role = new RoleEntity();
        role.setRoleid(0);
        role.setRolename("USER");
        role.setUsername(user.getUsername());
        try {
            UserStatusEntity userStatus = new UserStatusEntity();
            userStatus.setStatusid(0);
            userStatus.setUsername(username);
            userStatus.setUserStatus("normal");
            userStatusRepository.save(userStatus);

            UserEntity newUser = userRepository.save(user);
            roleRepository.save(role);

            return newUser;
        }
        catch(Exception e){
            logger.debug("Register Error:"+e.getMessage());
            return null;
        }
    }
}
