package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
    List<CartEntity> findByUsername(String username);

    CartEntity findByCartid(Integer cartid);

    CartEntity findByUsernameAndBookid(String username, Integer bookid);
}
