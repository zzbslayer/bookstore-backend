package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.BookEntity;
import com.zzbslayer.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<BookEntity> findByBooknameAndAuthorAndLang(String bookname,String author,String lang){
        return bookRepository.findByBooknameAndAuthorAndLang(bookname,author,lang);
    }

    public List<BookEntity> findByLang(String lang){
        return bookRepository.findByLang(lang);
    }

    public List<BookEntity> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<BookEntity> findByAuthorContains(String author){
        return bookRepository.findByAuthorContains(author);
    }

    public List<BookEntity> findByBookname(String bookname){
        return bookRepository.findByBookname(bookname);
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