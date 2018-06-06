package com.zzbslayer.bookstore.utils;

import java.io.Serializable;

public class BookidandCount implements Serializable{
    private int bookid;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
