package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.*;
import com.zzbslayer.bookstore.utils.OrderwithBooks;

import java.util.List;

public interface OrderService {
    List<OrderwithBooks> findOrderByUsername(String username);

    UserorderEntity addOrder(List<String> books, Integer addressid);
}
