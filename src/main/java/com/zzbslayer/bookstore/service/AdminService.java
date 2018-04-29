package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.dao.*;
import com.zzbslayer.bookstore.datamodel.domain.BookEntity;
import com.zzbslayer.bookstore.datamodel.domain.CategoryEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserEntity;
import com.zzbslayer.bookstore.datamodel.domain.UserStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<UserStatusEntity> findStatusAll(){
        return userStatusRepository.findAll();
    }

    public UserStatusEntity findStatusByUsername(String username) {
        return userStatusRepository.findByUsername(username);
    }

    public UserStatusEntity ban(String username){
        UserStatusEntity status = userStatusRepository.findByUsername(username);
        if (status==null)
            return null;
        status.setUserStatus("BAN");
        userStatusRepository.save(status);
        return status;
    }

    public UserStatusEntity restore(String username) {
        UserStatusEntity status = userStatusRepository.findByUsername(username);
        if (status==null)
            return null;
        status.setUserStatus("NORMAL");
        userStatusRepository.save(status);
        return status;
    }

    public void deleteUser(String username){
        roleRepository.deleteAll(roleRepository.findByUsername(username));
        userStatusRepository.delete(userStatusRepository.findByUsername(username));
        userRepository.delete(userRepository.findByUsername(username));
    }

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findUserAll(){
        return userRepository.findAll();
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
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
