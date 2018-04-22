package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.BookEntity;
import com.zzbslayer.bookstore.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
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

    @GetMapping(value="/books/author/{author}")
    @ResponseBody
    public JSONArray findByAuther(@PathVariable String author) {
        List<BookEntity> books = bookService.findByAuthorContains(author);
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/language/{lang}")
    @ResponseBody
    public JSONArray findByLang(@PathVariable String lang) {
        List<BookEntity> books = bookService.findByLang(lang);
        return JSONArray.fromObject(books);
    }

    @GetMapping(value="/books/vague/{msg}")
    @ResponseBody
    public JSONArray vagueFind(@PathVariable String msg){
        List<BookEntity> books = bookService.VagueFind(msg);
        return JSONArray.fromObject(books);
    }

    @PostMapping(value="/books/search")
    @ResponseBody
    public JSONArray accurateFind(@RequestParam("bookname") String bookname, @RequestParam("author") String author, @RequestParam("lang") String lang, @RequestParam("down_price") BigDecimal down_price, @RequestParam("up_price") BigDecimal up_price, @RequestParam("down_year") Integer down_year, @RequestParam("up_year") Integer up_year){
        if (bookname.equals("null")){
            bookname = "";
        }
        if (author.equals("null")){
            author = "";
        }
        if (lang.equals("null")){
            lang = "";
        }

        List<BookEntity> books = bookService.accurateFind(bookname,author,lang,down_price,up_price,down_year,up_year);
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