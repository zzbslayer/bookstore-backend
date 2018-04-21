package com.zzbslayer.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "bookstore", catalog = "")
@IdClass(CategoryEntityPK.class)
public class CategoryEntity {
    private int categoryid;
    private int bookid;
    private String category;

    @Id
    @Column(name = "categoryid", nullable = false)
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Id
    @Column(name = "bookid", nullable = false)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 30)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryid != that.categoryid) return false;
        if (bookid != that.bookid) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid;
        result = 31 * result + bookid;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
