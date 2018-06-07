package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private UserRepository userRepository;

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
        user.setRolename("USER");
        user.setStatus("NORMAL");

        try {
            UserEntity newUser = userRepository.save(user);
            return newUser;
        }
        catch(Exception e){
            logger.debug("Register Error:"+e.getMessage());
            return null;
        }
    }
}
