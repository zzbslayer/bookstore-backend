package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findByBookid(Integer bookid);

    List<CategoryEntity> findByCategoryContains(String category);
}
