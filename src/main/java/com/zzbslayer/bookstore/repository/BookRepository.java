package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.model.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer > {

    List<BookEntity>findAll();

    BookEntity findByBookid(Integer id);

    List<BookEntity> findByBooknameAndAuthorAndLang(String bookname,String auther,String lang);

    List<BookEntity> findByBookname(String bookname);

    List<BookEntity> findByBooknameContains(String bookname);

    List<BookEntity> findByAuthor(String auther);

    List<BookEntity> findByAuthorContains(String auther);

    List<BookEntity> findByLang(String lang);

}
