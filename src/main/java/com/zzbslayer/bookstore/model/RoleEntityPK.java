package com.zzbslayer.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RoleEntityPK implements Serializable {
    private int roleid;
    private String username;

    @Column(name = "roleid", nullable = false)
    @Id
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
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

        RoleEntityPK that = (RoleEntityPK) o;

        if (roleid != that.roleid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
