package com.zzbslayer.bookstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "userstatus", schema = "bookstore", catalog = "")
public class UserStatusEntity {
    private String username;
    private String user_status;

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "user_status", nullable = true, length = 10)
    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String userStatus) {
        this.user_status = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStatusEntity that = (UserStatusEntity) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (user_status != null ? !user_status.equals(that.user_status) : that.user_status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (user_status != null ? user_status.hashCode() : 0);
        return result;
    }
}
