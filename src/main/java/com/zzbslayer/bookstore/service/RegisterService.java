package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    UserEntity register(String username, String password, String email, String phone);
}
