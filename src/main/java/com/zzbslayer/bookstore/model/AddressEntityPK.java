package com.zzbslayer.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class AddressEntityPK implements Serializable {
    private String username;
    private BigInteger addressid;

    @Column(name = "username", nullable = false, length = 20)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "addressid", nullable = false, precision = 0)
    @Id
    public BigInteger getAddressid() {
        return addressid;
    }

    public void setAddressid(BigInteger addressid) {
        this.addressid = addressid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntityPK that = (AddressEntityPK) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (addressid != null ? !addressid.equals(that.addressid) : that.addressid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (addressid != null ? addressid.hashCode() : 0);
        return result;
    }
}
