package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.Cart;
import java.util.List;

public interface CartService {

    Cart editCart(String username, Integer bookid, Integer count);
    Cart addCart(Integer bookid, Integer count, String username);
    Cart deleteByBookid(Integer bookid, String username);
    List<BookEntity> findByUsername(String username);
}
