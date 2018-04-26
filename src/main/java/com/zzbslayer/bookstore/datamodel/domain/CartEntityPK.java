package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CartEntityPK implements Serializable {
    private int cartid;
    private String username;
    private int bookid;

    @Column(name = "cartid", nullable = false)
    @Id
    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    @Column(name = "username", nullable = false, length = 20)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "bookid", nullable = false)
    @Id
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntityPK that = (CartEntityPK) o;

        if (cartid != that.cartid) return false;
        if (bookid != that.bookid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + bookid;
        return result;
    }
}
