package com.zzbslayer.bookstore.utils;

import com.zzbslayer.bookstore.datamodel.domain.AddressEntity;
import com.zzbslayer.bookstore.datamodel.domain.OrderbookEntity;

import java.util.List;

public class OrderwithBooks {
    private List<OrderbookEntity> books;
    private AddressEntity address;
    private Integer orderid;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setBooks(List<OrderbookEntity> books) {
        this.books = books;
    }

    public List<OrderbookEntity> getBooks() {
        return books;
    }
}
