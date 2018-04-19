package com.zzbslayer.bookstore.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "addresses", schema = "bookstore", catalog = "")
@IdClass(AddressEntityPK.class)
public class AddressEntity {
    private String username;
    private BigInteger addressid;
    private String shippingaddress;
    private String recipient;
    private String phone;

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
    @Column(name = "shippingaddress", nullable = true, length = 500)
    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
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
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (addressid != null ? !addressid.equals(that.addressid) : that.addressid != null) return false;
        if (shippingaddress != null ? !shippingaddress.equals(that.shippingaddress) : that.shippingaddress != null)
            return false;
        if (recipient != null ? !recipient.equals(that.recipient) : that.recipient != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (addressid != null ? addressid.hashCode() : 0);
        result = 31 * result + (shippingaddress != null ? shippingaddress.hashCode() : 0);
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
