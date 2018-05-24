package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.BookRepository;
import com.zzbslayer.bookstore.datamodel.dao.CartRepository;
import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.CartEntity;
import com.zzbslayer.bookstore.service.CartService;
import com.zzbslayer.bookstore.utils.BookinCart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public void deleteByCartid(Integer cartid){
        CartEntity cart = cartRepository.findByCartid(cartid);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals(cart.getUsername())){
            cartRepository.delete(cart);
        }

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

            bookinCart.setCount(temp.getCount());
            bookinCart.setCartid(temp.getCartid());

            bookinCart.setByBookEntity(book);

            books.add(bookinCart);
        }
        return books;
    }

    public CartEntity addToCart(Integer bookid, Integer count, String username){
        CartEntity cart = cartRepository.findByUsernameAndBookid(username,bookid);
        if (cart==null){
            cart = new CartEntity();
            cart.setCartid(0);
            cart.setUsername(username);
            cart.setBookid(bookid);
            cart.setCount(count);
            return cartRepository.save(cart);
        }
        else{
            cart.setCount(cart.getCount()+count);
            return cartRepository.save(cart);
        }
    }

    public CartEntity editCart(String username, Integer bookid, Integer count){
        CartEntity cart = cartRepository.findByUsernameAndBookid(username,bookid);
        if (cart==null){
            return null;
        }
        else{
            cart.setCount(count);
            return cartRepository.save(cart);
        }
    }
}
