package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value="/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value="/users")
    @ResponseBody
    public JSONArray findAll(){
        List<UserEntity> users = adminService.findUserAll();
        return JSONArray.fromObject(users);
    }

    @PostMapping(value="/users/ban")
    @ResponseBody
    public JSONObject ban(@RequestParam("username")String username){
        return JSONObject.fromObject(adminService.ban(username));
    }

    @PostMapping(value="/users/restore")
    @ResponseBody
    public JSONObject restore(@RequestParam("username")String username){
        return JSONObject.fromObject(adminService.restore(username));
    }

    @PostMapping(value="/user/delete")
    @ResponseBody
    public void deleteUser(@RequestParam("username")String username){
        adminService.deleteUser(username);
    }

    @PostMapping(value="/books/update")
    @ResponseBody
    public JSONObject updateBook(@RequestParam("bookid")Integer bookid, @RequestParam("bookname")String bookname, @RequestParam("author")String author, @RequestParam("lang")String lang, @RequestParam("price")BigDecimal price, @RequestParam("year")Integer year, @RequestParam("count")Integer count, @RequestParam("imgsrc")String imgsrc){
        BookEntity book = new BookEntity();
        book.setBookid(bookid);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setLang(lang);
        book.setCount(count);
        book.setImgsrc(imgsrc);
        book.setPrice(price);
        book.setYear(year);
        return JSONObject.fromObject(adminService.updateBook(book));
    }

    @PostMapping(value="/books/save")
    @ResponseBody
    public JSONObject saveBook(@RequestParam("bookname")String bookname, @RequestParam("author")String author, @RequestParam("lang")String lang, @RequestParam("price")BigDecimal price, @RequestParam("year")Integer year, @RequestParam("count")Integer count, @RequestParam("imgsrc")String imgsrc,@RequestParam("category")String category){
        BookEntity book = new BookEntity();
        book.setBookid(0);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setLang(lang);
        book.setCount(count);
        book.setImgsrc(imgsrc);
        book.setPrice(price);
        book.setYear(year);
        return JSONObject.fromObject(adminService.saveBook(book,category));
    }

    @PostMapping(value="/books/delete")
    @ResponseBody
    public void deleteBook(@RequestParam("bookid")Integer bookid){
        adminService.deleteBook(bookid);
    }



    /*
    @RequestMapping("saveUserStatusEntity")
    @ResponseBody
    public void saveUserStatusEntity() {
        UserStatusEntity u = new UserStatusEntity();
        u.setUserStatusname("Evan_song");
        u.setPw("xixixi");
        u.setEmail("evansong@sjtu.edu.cn");
        u.setPhone("18033245325");
        u.setPermission("user");
        userRepository.save(u);
    }
    */
}