package com.zzbslayer.bookstore.datamodel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzbslayer.bookstore.utils.AddressRow;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Document
public class Address implements Serializable{
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Indexed(unique = true)
    private String username;

    private List<AddressRow> addresses;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAddresses(List<AddressRow> addresses) {
        this.addresses = addresses;
    }

    public List<AddressRow> getAddresses() {
        return addresses;
    }

    public AddressRow findByAddressid(Integer id){
        List<AddressRow> addressRows = this.getAddresses();
        for (AddressRow addressRow : addressRows){
            if (addressRow.getAddressid()==id)
                return addressRow;
        }
        return null;
    }
}
