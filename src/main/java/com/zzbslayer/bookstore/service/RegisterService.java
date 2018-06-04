package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.UserEntity;

public interface RegisterService {
    UserEntity register(String username, String password, String email, String phone);
}
