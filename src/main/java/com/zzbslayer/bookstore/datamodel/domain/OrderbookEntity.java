package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderbooks", schema = "bookstore", catalog = "")
@IdClass(OrderbookEntityPK.class)
public class OrderbookEntity {
    private int obid;
    private int orderid;
    private int bookid;
    private String bookname;
    private String author;
    private String lang;
    private BigDecimal price;
    private int year;
    private int amount;
    private String imgsrc;

    @Id
    @Column(name = "obid", nullable = false)
    public int getObid() {
        return obid;
    }

    public void setObid(int obid) {
        this.obid = obid;
    }

    @Id
    @Column(name = "orderid", nullable = false)
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Id
    @Column(name = "bookid", nullable = false)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "bookname", nullable = false, length = 70)
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 40)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "lang", nullable = false, length = 20)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "year", nullable = false, precision = 0)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "imgsrc", nullable = false, length = 500)
    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderbookEntity that = (OrderbookEntity) o;

        if (obid != that.obid) return false;
        if (orderid != that.orderid) return false;
        if (bookid != that.bookid) return false;
        if (year != that.year) return false;
        if (amount != that.amount) return false;
        if (bookname != null ? !bookname.equals(that.bookname) : that.bookname != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (imgsrc != null ? !imgsrc.equals(that.imgsrc) : that.imgsrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = obid;
        result = 31 * result + orderid;
        result = 31 * result + bookid;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + amount;
        result = 31 * result + (imgsrc != null ? imgsrc.hashCode() : 0);
        return result;
    }
}
