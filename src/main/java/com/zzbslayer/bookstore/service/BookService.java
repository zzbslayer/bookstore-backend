package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.BookEntity;
import com.zzbslayer.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository userRepository;

    public List<BookEntity> findAll(){
        return userRepository.findAll();
    }

    public BookEntity findByBookid(Integer bookid){
        return userRepository.findByBookid(bookid);
    }

    public List<BookEntity> findByBooknameAndAutherAndLang(String bookname,String auther,String lang){
        return userRepository.findByBooknameAndAutherAndLang(bookname,auther,lang);
    }

    public List<BookEntity> findByLang(String lang){
        return userRepository.findByLang(lang);
    }

    public List<BookEntity> findByAuther(String auther){
        return userRepository.findByAuther(auther);
    }

    public List<BookEntity> findByAutherContains(String auther){
        return userRepository.findByAutherContains(auther);
    }

    public List<BookEntity> findByBookname(String bookname){
        return userRepository.findByBookname(bookname);
    }

    public List<BookEntity> findByBooknameContains(String bookname){
        return userRepository.findByBooknameContains(bookname);
    }

    public List<BookEntity> VagueFind(String msg){
        List<BookEntity> array1 = userRepository.findByBooknameContains(msg);
        List<BookEntity> array2 = userRepository.findByAutherContains(msg);
        array1.removeAll(array2);
        array1.addAll(array2);
        return array1;
    }
}