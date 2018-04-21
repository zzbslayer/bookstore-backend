package com.zzbslayer.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BookImageEntityPK implements Serializable {
    private int bookimageid;
    private int bookid;

    @Column(name = "bookimageid", nullable = false)
    @Id
    public int getBookimageid() {
        return bookimageid;
    }

    public void setBookimageid(int bookimageid) {
        this.bookimageid = bookimageid;
    }

    @Column(name = "bookid", nullable = false)
    @Id
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookImageEntityPK that = (BookImageEntityPK) o;

        if (bookimageid != that.bookimageid) return false;
        if (bookid != that.bookid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookimageid;
        result = 31 * result + bookid;
        return result;
    }
}
