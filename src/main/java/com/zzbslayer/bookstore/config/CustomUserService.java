package com.zzbslayer.bookstore.config;

import com.zzbslayer.bookstore.datamodel.dao.UserStatusRepository;
import com.zzbslayer.bookstore.datamodel.domain.RoleEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.dao.RoleRepository;
import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
import com.zzbslayer.bookstore.datamodel.domain.UserStatusEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { // custom UserService interface
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserStatusRepository userStatusRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        UserStatusEntity status = userStatusRepository.findByUsername(username);
        if (status!=null) {
            if (status.getUserStatus().equals("BAN")) {
                logger.debug("Banned user "+username+" tried to login");
                throw new UsernameNotFoundException("User Is Banned");
            }
        }

        List<RoleEntity> roles = roleRepository.findByUsername(username);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getUsername()));
        }

        return new User(user.getUsername(),
                user.getPw(),getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(UserEntity user) {

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();

        String username = user.getUsername();

        List<RoleEntity> roles = roleRepository.findByUsername(username);
        for (RoleEntity role : roles){
            if (role.getRolename().equals("ADMIN")) {
                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            else if (role.getRolename().equals("USER")) {
                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
        }
        return grantedAuthority;
    }
}
