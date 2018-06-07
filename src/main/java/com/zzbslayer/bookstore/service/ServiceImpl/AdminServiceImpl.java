package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.*;
import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserRepository userRepository;



    public UserEntity ban(String username){
        UserEntity user = userRepository.findByUsername(username);
        user.setStatus("BAN");
        userRepository.save(user);
        return user;
    }

    public UserEntity restore(String username) {
        UserEntity user = userRepository.findByUsername(username);
        user.setStatus("NORMAL");
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }

    public List<UserEntity> findUserAll(){
        return userRepository.findAll();
    }

    public UserEntity findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public BookEntity updateBook(BookEntity book){
        bookRepository.save(book);
        return bookRepository.findByBooknameAndAuthorAndCountAndImgsrcAndLangAndPriceAndYear(book.getBookname(), book.getAuthor(),book.getCount(),book.getImgsrc(),book.getLang(),book.getPrice(),book.getYear());
    }

    public BookEntity saveBook(BookEntity book, String category){
        bookRepository.save(book);
        BookEntity abook = bookRepository.findByBooknameAndAuthorAndCountAndImgsrcAndLangAndPriceAndYear(book.getBookname(), book.getAuthor(),book.getCount(),book.getImgsrc(),book.getLang(),book.getPrice(),book.getYear());

        CategoryEntity cate = new CategoryEntity();
        cate.setBookid(abook.getBookid());
        cate.setCategory(category);
        cate.setCategoryid(0);
        categoryRepository.save(cate);
        return abook;
    }

    public  void deleteBook(Integer bookid){
        bookRepository.delete(bookRepository.findByBookid(bookid));
    }
}
