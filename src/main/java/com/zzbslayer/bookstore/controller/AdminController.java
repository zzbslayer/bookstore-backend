package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserStatusEntity;
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

    @GetMapping(value="/userstatus")
    @ResponseBody
    public JSONArray findAll(){
        List<UserStatusEntity> userstatus = adminService.findStatusAll();
        return JSONArray.fromObject(userstatus);
    }

    @PostMapping(value="/userstatus/ban")
    @ResponseBody
    public JSONObject ban(@RequestParam("username")String username){
        return JSONObject.fromObject(adminService.ban(username));
    }

    @PostMapping(value="/userstatus/restore")
    @ResponseBody
    public JSONObject restore(@RequestParam("username")String username){
        return JSONObject.fromObject(adminService.restore(username));
    }

    @PostMapping(value="/userstatus/delete")
    @ResponseBody
    public void deleteUser(@RequestParam("username")String username){
        adminService.deleteUser(username);
    }

    @GetMapping(value="/userstatus/{username}")
    @ResponseBody
    public JSONObject findStatusByUsername(@PathVariable String username) {
        UserStatusEntity user = adminService.findStatusByUsername(username);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/users/username/{username}")
    @ResponseBody
    public JSONObject findUserByUsername(@PathVariable String username){
        UserEntity user = adminService.findUserByUsername(username);
        return JSONObject.fromObject(user);
    }

    @GetMapping(value="/users/email/{email}")
    @ResponseBody
    public JSONObject findUserByEmail(@PathVariable String email){
        UserEntity user = adminService.findUserByEmail(email);
        return JSONObject.fromObject(user);
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
        return JSONObject.fromObject(adminService.saveBook(book));
    }

    @PostMapping(value="/books/save")
    @ResponseBody
    public JSONObject saveBook(@RequestParam("bookname")String bookname, @RequestParam("author")String author, @RequestParam("lang")String lang, @RequestParam("price")BigDecimal price, @RequestParam("year")Integer year, @RequestParam("count")Integer count, @RequestParam("imgsrc")String imgsrc){
        BookEntity book = new BookEntity();
        book.setBookid(0);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setLang(lang);
        book.setCount(count);
        book.setImgsrc(imgsrc);
        book.setPrice(price);
        book.setYear(year);
        return JSONObject.fromObject(adminService.saveBook(book));
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