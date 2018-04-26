package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer > {

    List<BookEntity>findAll();

    BookEntity findByBookid(Integer id);

    List<BookEntity> findByBooknameContainsAndAuthorContainsAndLangContainsAndPriceBetweenAndAndYearBetween(String bookname, String author, String lang,BigDecimal down_price, BigDecimal up_price, Integer down_year, Integer up_year);

    List<BookEntity> findByBooknameContains(String bookname);

    List<BookEntity> findByAuthorContains(String auther);

    List<BookEntity> findByLang(String lang);

    BookEntity findByBooknameAndAuthorAndCountAndImgsrcAndLangAndPriceAndYear(String bookname,String auther,Integer count,String Imgsrc,String lang,BigDecimal price,Integer year);

}
