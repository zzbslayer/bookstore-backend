package com.zzbslayer.bookstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "book", schema = "bookstore", catalog = "")
public class BookEntity {
    private int bookid;
    private String bookname;
    private String auther;
    private String lang;
    private BigDecimal price;
    private Integer year;
    private Integer count;
    private String imgsrc;

    @Id
    @Column(name = "bookid", nullable = false, precision = 0)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "bookname", nullable = true, length = 70)
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "auther", nullable = true, length = 40)
    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    @Basic
    @Column(name = "lang", nullable = true, length = 20)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "year", nullable = true, precision = 0)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "count", nullable = true, precision = 0)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "imgsrc", nullable = true, length = 300)
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

        BookEntity that = (BookEntity) o;

        if (bookid != that.bookid) return false;
        if (bookname != null ? !bookname.equals(that.bookname) : that.bookname != null) return false;
        if (auther != null ? !auther.equals(that.auther) : that.auther != null) return false;
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (imgsrc != null ? !imgsrc.equals(that.imgsrc) : that.imgsrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookid;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (auther != null ? auther.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (imgsrc != null ? imgsrc.hashCode() : 0);
        return result;
    }
}
