package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    public BookEntity findByBookid(Integer bookid){
        return bookRepository.findByBookid(bookid);
    }

    public List<BookEntity> accurateFind(String bookname, String author, String lang, BigDecimal down_price, BigDecimal up_price, Integer down_year, Integer up_year){

        return bookRepository.findByBooknameContainsAndAuthorContainsAndLangContainsAndPriceBetweenAndAndYearBetween(bookname,author,lang,down_price,up_price,down_year,up_year);
    }

    public List<BookEntity> findByLang(String lang){
        return bookRepository.findByLang(lang);
    }

    public List<BookEntity> findByAuthorContains(String author){
        return bookRepository.findByAuthorContains(author);
    }

    public List<BookEntity> findByBooknameContains(String bookname){
        return bookRepository.findByBooknameContains(bookname);
    }

    public List<BookEntity> VagueFind(String msg){
        List<BookEntity> array1 = bookRepository.findByBooknameContains(msg);
        List<BookEntity> array2 = bookRepository.findByAuthorContains(msg);
        array1.removeAll(array2);
        array1.addAll(array2);
        return array1;
    }
}