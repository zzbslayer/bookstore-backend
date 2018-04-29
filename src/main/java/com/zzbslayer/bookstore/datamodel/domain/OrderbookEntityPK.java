package com.zzbslayer.bookstore.datamodel.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderbookEntityPK implements Serializable {
    private int obid;
    private int orderid;
    private int bookid;

    @Column(name = "obid", nullable = false)
    @Id
    public int getObid() {
        return obid;
    }

    public void setObid(int obid) {
        this.obid = obid;
    }

    @Column(name = "orderid", nullable = false)
    @Id
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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

        OrderbookEntityPK that = (OrderbookEntityPK) o;

        if (obid != that.obid) return false;
        if (orderid != that.orderid) return false;
        if (bookid != that.bookid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = obid;
        result = 31 * result + orderid;
        result = 31 * result + bookid;
        return result;
    }
}
