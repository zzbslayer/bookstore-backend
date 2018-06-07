package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.BookRepository;
import com.zzbslayer.bookstore.datamodel.dao.CartRepository;
import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.Cart;
import com.zzbslayer.bookstore.service.CartService;
import com.zzbslayer.bookstore.utils.BookidandCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartsRepository;

    public Cart addCart(Integer bookid, Integer count, String username){
        BookidandCount line = new BookidandCount();
        line.setBookid(bookid);
        line.setCount(count);
        List<BookidandCount> cart;

        Cart cartsEntity = cartsRepository.findByUsername(username);
        if (cartsEntity == null){
            cartsEntity = new Cart();
            cartsEntity.setUsername(username);
            cart = new ArrayList<>();
            cart.add(line);
            cartsEntity.setCart(cart);
            cartsRepository.save(cartsEntity);
            return cartsEntity;
        }

        cart = cartsEntity.getCart();
        boolean findflag = false;
        for (BookidandCount i : cart){
            if (i.getBookid() == bookid) {
                i.setCount(i.getCount() + count);
                findflag = true;
                break;
            }
        }
        if (!findflag){
            cart.add(line);
        }
        cartsEntity.setCart(cart);
        cartsRepository.save(cartsEntity);
        return cartsEntity;
    }

    public Cart deleteByBookid(Integer bookid, String username){
        Cart cartsEntity = cartsRepository.findByUsername(username);
        List<BookidandCount> cart = cartsEntity.getCart();
        for (BookidandCount i : cart){
            if (i.getBookid() == bookid){
                cart.remove(i);
                 cartsRepository.save(cartsEntity);
                return cartsEntity;
            }
        }
        logger.debug("Delete an unexisted book in the cart of user:"+username);
        return null;
    }

    public List<BookEntity> findByUsername(String username){

        Cart cartsEntity = cartsRepository.findByUsername(username);
        if (cartsEntity == null){
            cartsEntity = new Cart();
            cartsEntity.setCart(new ArrayList<>());
            cartsEntity.setUsername(username);
            cartsRepository.save(cartsEntity);
            return null;
        }
        List<BookEntity> books = new ArrayList<>();
        List<BookidandCount> cart = cartsEntity.getCart();
        for (BookidandCount i : cart){
            Integer id = i.getBookid();
            BookEntity bookEntity = bookRepository.findByBookid(id);
            bookEntity.setCount(i.getCount());
            books.add(bookEntity);
        }
        return books;
    }

    public Cart editCart(String username, Integer bookid, Integer count){
        Cart cartEntity = cartsRepository.findByUsername(username);
        List<BookidandCount> cart = cartEntity.getCart();
        for (BookidandCount i : cart){
            if (i.getBookid()==bookid){
                i.setCount(count);
                cartsRepository.save(cartEntity);
                return cartEntity;
            }
        }
        logger.debug("Edit an unexisted book in the cart of user:"+username);
        return null;
    }
}
