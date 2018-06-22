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
public class Avatar implements Serializable {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Indexed(unique = true)
    private String username;

    private String avatar;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }
}
