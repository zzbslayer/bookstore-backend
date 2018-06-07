package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.*;
import com.zzbslayer.bookstore.utils.AddressRow;

import java.util.List;

public interface OrderService {
    List<Order> findOrderByUsername(String username);

    Order addOrder(List<String> books, String shippingaddress, String recipient, String phone);
}
