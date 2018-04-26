package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.RoleEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserStatusEntity;
import com.zzbslayer.bookstore.datamodel.dao.RoleRepository;
import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
import com.zzbslayer.bookstore.datamodel.dao.UserStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashstr = encoder.encode(password);
        user.setPw(hashstr);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar("null");

        RoleEntity role = new RoleEntity();
        role.setRoleid(0);
        role.setRolename("USER");
        role.setUsername(user.getUsername());
        try {
            UserStatusEntity userStatus = new UserStatusEntity();
            userStatus.setStatusid(0);
            userStatus.setUsername(username);
            userStatus.setUserStatus("NORMAL");

            UserEntity newUser = userRepository.save(user);
            userStatusRepository.save(userStatus);
            roleRepository.save(role);

            return newUser;
        }
        catch(Exception e){
            logger.debug("Register Error:"+e.getMessage());
            return null;
        }
    }
}
