package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.domain.BookImageEntity;
import com.zzbslayer.bookstore.repository.BookImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookImageService {
    @Autowired
    private BookImageRepository bookImageRepository;

    public List<BookImageEntity> findAll(){
        List<BookImageEntity> images = bookImageRepository.findAll();
        return images;
    }

    public BookImageEntity findByBookid(Integer bookid){
        BookImageEntity image = bookImageRepository.findByBookid(bookid);
        return image;
    }
}
