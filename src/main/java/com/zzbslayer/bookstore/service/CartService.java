package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.model.BookEntity;
import com.zzbslayer.bookstore.model.BookinCart;
import com.zzbslayer.bookstore.model.CartEntity;
import com.zzbslayer.bookstore.repository.BookRepository;
import com.zzbslayer.bookstore.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public void deleteByCartid(Integer cartid){
        cartRepository.delete(cartRepository.findByCartid(cartid));
    }

    public List<BookinCart> findByUsername(String username){
        logger.debug(username+" attempted to get the cart");
        List<CartEntity> cart = cartRepository.findByUsername(username);
        logger.debug(cart.toString());
        List<BookinCart> books = new ArrayList<>();
        for (CartEntity temp : cart){
            Integer id = temp.getBookid();
            BookEntity book = bookRepository.findByBookid(id);
            logger.debug(book.toString());
            BookinCart bookinCart = new BookinCart();
            bookinCart.setAuthor(book.getAuthor());
            bookinCart.setBookid(book.getBookid());
            bookinCart.setBookname(book.getBookname());

            bookinCart.setCount(temp.getCount());

            bookinCart.setImgsrc(book.getImgsrc());
            bookinCart.setInventory(book.getCount());
            bookinCart.setLang(book.getLang());
            bookinCart.setPrice(book.getPrice());
            bookinCart.setYear(book.getYear());
            bookinCart.setSelect(false);
            bookinCart.setCartid(temp.getCartid());
            books.add(bookinCart);
        }
        return books;
    }
}
