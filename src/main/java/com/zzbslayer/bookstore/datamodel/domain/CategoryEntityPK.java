package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CategoryEntityPK implements Serializable {
    private int categoryid;
    private int bookid;

    @Column(name = "categoryid", nullable = false)
    @Id
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
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

        CategoryEntityPK that = (CategoryEntityPK) o;

        if (categoryid != that.categoryid) return false;
        if (bookid != that.bookid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid;
        result = 31 * result + bookid;
        return result;
    }
}
