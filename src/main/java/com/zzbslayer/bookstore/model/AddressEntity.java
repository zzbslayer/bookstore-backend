package com.zzbslayer.bookstore.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "addresses", schema = "bookstore", catalog = "")
@IdClass(AddressEntityPK.class)
public class AddressEntity {
    private String username;
    private BigInteger addressid;
    private String shippingAddress;
    private String recipient;
    private Integer phone;

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "addressid", nullable = false, precision = 0)
    public BigInteger getAddressid() {
        return addressid;
    }

    public void setAddressid(BigInteger addressid) {
        this.addressid = addressid;
    }

    @Basic
    @Column(name = "shippingAddress", nullable = true, length = 500)
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "recipient", nullable = true, length = 40)
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Basic
    @Column(name = "phone", nullable = true, precision = 0)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (addressid != null ? !addressid.equals(that.addressid) : that.addressid != null) return false;
        if (shippingAddress != null ? !shippingAddress.equals(that.shippingAddress) : that.shippingAddress != null)
            return false;
        if (recipient != null ? !recipient.equals(that.recipient) : that.recipient != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (addressid != null ? addressid.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
