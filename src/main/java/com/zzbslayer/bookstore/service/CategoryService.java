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
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findByBookid(Integer bookid){
        return categoryRepository.findByBookid(bookid);
    }

    public List<CategoryEntity> findByCategoryContains(String category){
        List<CategoryEntity> categories = categoryRepository.findByCategoryContains(category);
        Set<Integer> ids = new HashSet<>();
        Iterator<CategoryEntity> iter = categories.iterator();
        while (iter.hasNext()) {
            CategoryEntity cate = iter.next();
            if (ids.contains(cate.getBookid())) {
                iter.remove();
            }
            else
                ids.add(cate.getBookid());
        }
        return categories;
    }
}
