package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.*;

@Entity
@Table(name = "userstatus", schema = "bookstore", catalog = "")
@IdClass(UserStatusEntityPK.class)
public class UserStatusEntity {
    private int statusid;
    private String username;
    private String userStatus;

    @Id
    @Column(name = "statusid", nullable = false)
    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "user_status", nullable = false, length = 10)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStatusEntity that = (UserStatusEntity) o;

        if (statusid != that.statusid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userStatus != null ? !userStatus.equals(that.userStatus) : that.userStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        return result;
    }
}
