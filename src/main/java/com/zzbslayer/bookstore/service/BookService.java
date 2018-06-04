package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;

import java.math.BigDecimal;
import java.util.List;

public interface BookService{
    List<BookEntity> findAll();
    BookEntity findByBookid(Integer bookid);
    List<BookEntity> findByLang(String lang);
    List<BookEntity> findByAuthorContains(String author);
    List<BookEntity> findByBooknameContains(String bookname);

    List<BookEntity> accurateFind(String bookname, String author, String lang, BigDecimal down_price, BigDecimal up_price, Integer down_year, Integer up_year);
    List<BookEntity> VagueFind(String msg);
    Integer getSales(Integer bookid);

}