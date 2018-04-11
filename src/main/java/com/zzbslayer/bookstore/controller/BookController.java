package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.domain.BookEntity;
import com.zzbslayer.bookstore.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/books")
    @ResponseBody
    public JSONArray findAll(){
        List<BookEntity> books = bookService.findAll();
        System.out.println(JSONArray.fromObject(books));
        return JSONArray.fromObject(books);
    }

    @RequestMapping(value="/books/by/bookid/{bookid}")
    @ResponseBody
    public JSONObject findByBookid(@PathVariable Integer bookid) {
        BookEntity book = bookService.findByBookid(bookid);
        return JSONObject.fromObject(book);
    }

    @RequestMapping(value="/books/bookname/{bookname}")
    @ResponseBody
    public JSONArray findByBookname(@PathVariable String bookname) {
        List<BookEntity> books = bookService.findByBooknameContains(bookname);
        return JSONArray.fromObject(books);
    }

    @RequestMapping(value="/books/auther/{auther}")
    @ResponseBody
    public JSONArray findByAuther(@PathVariable String auther) {
        List<BookEntity> books = bookService.findByAutherContains(auther);
        return JSONArray.fromObject(books);
    }

    @RequestMapping(value="/books/language/{lang}")
    @ResponseBody
    public JSONArray findByLang(@PathVariable String lang) {
        List<BookEntity> books = bookService.findByLang(lang);
        return JSONArray.fromObject(books);
    }

    /*
    @RequestMapping("saveBookEntity")
    @ResponseBody
    public void saveBookEntity() {
        BookEntity u = new BookEntity();
        u.setBookname("Evan_song");
        u.setPw("xixixi");
        u.setEmail("evansong@sjtu.edu.cn");
        u.setPhone("18033245325");
        u.setPermission("user");
        userRepository.save(u);
    }
    */
}