package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserStatusEntity;

import java.util.List;


public interface AdminService {
    List<UserStatusEntity> findStatusAll();
    UserStatusEntity findStatusByUsername(String username);

    UserStatusEntity ban(String username);
    UserStatusEntity restore(String username);
    void deleteUser(String username);

    List<UserEntity> findUserAll();
    UserEntity findUserByEmail(String email);
    UserEntity findUserByUsername(String username);

    BookEntity updateBook(BookEntity book);
    BookEntity saveBook(BookEntity book, String category);
    void deleteBook(Integer bookid);


}
