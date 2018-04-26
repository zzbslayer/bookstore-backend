package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
    List<CategoryEntity> findAll();

    List<CategoryEntity> findByBookid(Integer bookid);

    List<CategoryEntity> findByCategoryContains(String category);
}
