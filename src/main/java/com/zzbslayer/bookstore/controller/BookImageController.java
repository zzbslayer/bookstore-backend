package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.domain.BookImageEntity;
import com.zzbslayer.bookstore.service.BookImageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookImageController {
    @Autowired
    private BookImageService bookImageService;

    @RequestMapping(value="/bookimages")
    @ResponseBody
    public JSONArray findAll(){
        List<BookImageEntity> images = bookImageService.findAll();
        System.out.println(JSONArray.fromObject(images));
        return JSONArray.fromObject(images);
    }

    @RequestMapping(value="/bookimages/bookid/{bookid}")
    @ResponseBody
    public JSONObject findByBookid(@PathVariable Integer bookid){
        BookImageEntity image = bookImageService.findByBookid(bookid);
        return JSONObject.fromObject(image);
    }
}
