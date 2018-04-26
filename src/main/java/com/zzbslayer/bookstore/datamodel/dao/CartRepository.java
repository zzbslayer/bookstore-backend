package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
    List<CartEntity> findByUsername(String username);

    CartEntity findByCartid(Integer cartid);

    CartEntity findByUsernameAndBookid(String username, Integer bookid);
}
