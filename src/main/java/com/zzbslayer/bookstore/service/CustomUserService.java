package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.RoleEntity;
import com.zzbslayer.bookstore.model.UserEntity;
import com.zzbslayer.bookstore.repository.RoleRepository;
import com.zzbslayer.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { // custom UserService interface

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        BCryptPasswordEncoder encoder = passwordEncoder();
        UserEntity user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        List<RoleEntity> roles = roleRepository.findByUsername(username);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getUsername()));
            System.out.println(role.getRolename());
        }

        return new User(user.getUsername(),
                encoder.encode(user.getPw()),getGrantedAuthorities(user));
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
