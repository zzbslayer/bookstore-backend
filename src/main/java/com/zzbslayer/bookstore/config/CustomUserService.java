package com.zzbslayer.bookstore.config;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.dao.UserRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        if (user.getStatus().equals("BAN")) {
            logger.debug("Banned user "+username+" tried to login");
            throw new UsernameNotFoundException("User Is Banned");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(username));

        return new User(user.getUsername(),
                user.getPw(),getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(UserEntity user) {

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();

        String username = user.getUsername();

        if (user.getRolename().equals("ADMIN")) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else if (user.getRolename().equals("USER")) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return grantedAuthority;
    }
}
