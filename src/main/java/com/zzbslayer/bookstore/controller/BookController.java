package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.BookEntity;
import com.zzbslayer.bookstore.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value="/books")
    @ResponseBody
    public JSONArray findAll(){
        List<BookEntity> books = bookService.findAll();
        System.out.println(JSONArray.fromObject(books));
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/bookid/{bookid}")
    @ResponseBody
    public JSONObject findByBookid(@PathVariable Integer bookid) {
        BookEntity book = bookService.findByBookid(bookid);
        return JSONObject.fromObject(book);
    }

    @GetMapping(value="/books/bookname/{bookname}")
    @ResponseBody
    public JSONArray findByBookname(@PathVariable String bookname) {
        List<BookEntity> books = bookService.findByBooknameContains(bookname);
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/auther/{auther}")
    @ResponseBody
    public JSONArray findByAuther(@PathVariable String auther) {
        List<BookEntity> books = bookService.findByAutherContains(auther);
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/language/{lang}")
    @ResponseBody
    public JSONArray findByLang(@PathVariable String lang) {
        List<BookEntity> books = bookService.findByLang(lang);
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/{msg}")
    @ResponseBody
    public JSONArray VagueFind(@PathVariable String msg){
        List<BookEntity> books = bookService.VagueFind(msg);
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