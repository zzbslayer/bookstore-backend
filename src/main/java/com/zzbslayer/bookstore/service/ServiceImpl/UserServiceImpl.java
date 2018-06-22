package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.AvatarRepository;
import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
import com.zzbslayer.bookstore.datamodel.domain.Avatar;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.x509.AVA;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findByUsername(String username){
        UserEntity user = userRepository.findByUsername(username);
        Avatar avatar = avatarRepository.findByUsername(username);
        if (avatar != null)
            user.setAvatar(avatar.getAvatar());
        return user;
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateInfo(UserEntity user){
        UserEntity toupdate = userRepository.findByUsername(user.getUsername());
        toupdate.setEmail(user.getEmail());
        toupdate.setPhone(user.getPhone());

        //System.out.println("no problem");
        Avatar avatar = avatarRepository.findByUsername(user.getUsername());
        if (avatar == null){
            avatar = new Avatar();
            avatar.setUsername(user.getUsername());
        }
        //System.out.println("avatar?");
        avatar.setAvatar(user.getAvatar());
        avatarRepository.save(avatar);

        return userRepository.save(toupdate);
    }
}
