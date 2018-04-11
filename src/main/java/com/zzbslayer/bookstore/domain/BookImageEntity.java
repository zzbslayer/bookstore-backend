package com.zzbslayer.bookstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "bookimages", schema = "bookstore", catalog = "")
public class BookImageEntity {
    private int bookid;
    private String imgsrc;

    @Id
    @Column(name = "bookid", nullable = false)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "imgsrc", nullable = true, length = 500)
    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookImageEntity that = (BookImageEntity) o;

        if (bookid != that.bookid) return false;
        if (imgsrc != null ? !imgsrc.equals(that.imgsrc) : that.imgsrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookid;
        result = 31 * result + (imgsrc != null ? imgsrc.hashCode() : 0);
        return result;
    }
}
