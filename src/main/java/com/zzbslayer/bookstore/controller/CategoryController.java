package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import com.zzbslayer.bookstore.service.BookService;
import com.zzbslayer.bookstore.service.CategoryService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;

    @GetMapping(value="/category/{category}")
    @ResponseBody
    public JSONArray findByCategoryContains(@PathVariable String category){
        List<CategoryEntity> categories = categoryService.findByCategoryContains(category);
        List<BookEntity> books = new ArrayList<>();
        for (CategoryEntity cate : categories){
            books.add(bookService.findByBookid(cate.getBookid()));
        }
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/bookid/{bookid}")
    @ResponseBody
    public JSONArray findByBookid(@PathVariable Integer bookid){
        List<CategoryEntity> categories = categoryService.findByBookid(bookid);
        return JSONArray.fromObject(categories);
    }
}