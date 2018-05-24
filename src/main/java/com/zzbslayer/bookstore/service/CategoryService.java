package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import com.zzbslayer.bookstore.datamodel.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public interface CategoryService {

    List<CategoryEntity> findByBookid(Integer bookid);

    List<CategoryEntity> findByCategoryContains(String category);
}
