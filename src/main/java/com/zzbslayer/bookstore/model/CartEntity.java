package com.zzbslayer.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "carts", schema = "bookstore", catalog = "")
@IdClass(CartEntityPK.class)
public class CartEntity {
    private int cartid;
    private String username;
    private int bookid;
    private int count;

    @Id
    @Column(name = "cartid", nullable = false)
    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (cartid != that.cartid) return false;
        if (bookid != that.bookid) return false;
        if (count != that.count) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + bookid;
        result = 31 * result + count;
        return result;
    }
}
