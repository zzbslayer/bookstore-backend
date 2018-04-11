package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.domain.BookImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookImageRepository extends JpaRepository<BookImageEntity, Integer>{

    List<BookImageEntity> findAll();

    BookImageEntity findByBookid(Integer bookid);

}
