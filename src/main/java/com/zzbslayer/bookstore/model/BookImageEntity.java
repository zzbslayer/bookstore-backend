package com.zzbslayer.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "bookimages", schema = "bookstore", catalog = "")
@IdClass(BookImageEntityPK.class)
public class BookImageEntity {
    private int bookimageid;
    private int bookid;
    private String imgsrc;

    @Id
    @Column(name = "bookimageid", nullable = false)
    public int getBookimageid() {
        return bookimageid;
    }

    public void setBookimageid(int bookimageid) {
        this.bookimageid = bookimageid;
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
    @Column(name = "imgsrc", nullable = false, length = 500)
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

        if (bookimageid != that.bookimageid) return false;
        if (bookid != that.bookid) return false;
        if (imgsrc != null ? !imgsrc.equals(that.imgsrc) : that.imgsrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookimageid;
        result = 31 * result + bookid;
        result = 31 * result + (imgsrc != null ? imgsrc.hashCode() : 0);
        return result;
    }
}
