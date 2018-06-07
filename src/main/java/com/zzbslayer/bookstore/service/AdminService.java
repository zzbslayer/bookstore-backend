package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import java.util.List;


public interface AdminService {

    UserEntity ban(String username);
    UserEntity restore(String username);
    void deleteUser(String username);

    List<UserEntity> findUserAll();
    UserEntity findUserByUsername(String username);

    BookEntity updateBook(BookEntity book);
    BookEntity saveBook(BookEntity book, String category);
    void deleteBook(Integer bookid);


}
