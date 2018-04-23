package com.zzbslayer.bookstore.model;

import java.math.BigDecimal;

public class BookinCart {
    private int cartid;
    private int bookid;
    private String bookname;
    private String author;
    private String lang;
    private BigDecimal price;
    private int year;
    private int inventory;
    private String imgsrc;
    private int count;
    private boolean select;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isSelect() {
        return select;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getBookid() {
        return bookid;
    }

    public int getCount() {
        return count;
    }

    public int getInventory() {
        return inventory;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookname() {
        return bookname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getLang() {
        return lang;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
