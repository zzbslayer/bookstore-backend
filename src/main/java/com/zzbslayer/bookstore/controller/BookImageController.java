package com.zzbslayer.bookstore.controller;

import com.zzbslayer.bookstore.model.BookImageEntity;
import com.zzbslayer.bookstore.service.BookImageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class BookImageController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookImageService bookImageService;

    @GetMapping(value="/bookimages")
    @ResponseBody
    public JSONArray findAll(){
        List<BookImageEntity> images = bookImageService.findAll();
        System.out.println(JSONArray.fromObject(images));
        return JSONArray.fromObject(images);
    }

    @GetMapping(value="/bookimages/bookid/{bookid}")
    @ResponseBody
    public JSONArray findByBookid(@PathVariable String bookid){
        bookid = bookid.replace("[","");
        bookid = bookid.replace("]","");
        String[] temp = bookid.split(",");
        int[] intArray = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            try {
                intArray[i] = Integer.parseInt(temp[i]);
            }
            catch (NumberFormatException nfe) {
                logger.debug("Error: bookid not a number");
                logger.debug("bookid : " + bookid);
                logger.debug("temp : " + temp);
                return JSONArray.fromObject(" NumberFormatException");
            }
        }

        List<BookImageEntity> images = new ArrayList<>();
        for (Integer id : intArray ) {
            images.add(bookImageService.findByBookid(id));
        }

        return JSONArray.fromObject(images);
    }
}
