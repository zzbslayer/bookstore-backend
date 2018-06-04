package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.utils.BookinCart;
import com.zzbslayer.bookstore.datamodel.domain.CartEntity;
import java.util.List;

public interface CartService {
    void deleteByCartid(Integer cartid);
    List<BookinCart> findByUsername(String username);

    CartEntity addToCart(Integer bookid, Integer count, String username);
    CartEntity editCart(String username, Integer bookid, Integer count);
}
