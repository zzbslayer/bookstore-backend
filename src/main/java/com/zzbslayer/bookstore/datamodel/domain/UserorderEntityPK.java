package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserorderEntityPK implements Serializable {
    private int orderid;
    private int addressid;
    private String username;

    @Column(name = "orderid", nullable = false)
    @Id
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Column(name = "addressid", nullable = false)
    @Id
    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    @Column(name = "username", nullable = false, length = 20)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserorderEntityPK that = (UserorderEntityPK) o;

        if (orderid != that.orderid) return false;
        if (addressid != that.addressid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + addressid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
