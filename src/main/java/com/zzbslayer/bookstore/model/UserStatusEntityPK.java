package com.zzbslayer.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserStatusEntityPK implements Serializable {
    private int statusid;
    private String username;

    @Column(name = "statusid", nullable = false)
    @Id
    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
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

        UserStatusEntityPK that = (UserStatusEntityPK) o;

        if (statusid != that.statusid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
