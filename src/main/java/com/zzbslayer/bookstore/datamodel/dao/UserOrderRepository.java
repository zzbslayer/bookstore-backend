package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.UserorderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserorderEntity, Integer > {

    List<UserorderEntity> findByUsername(String username);
    UserorderEntity findByUsernameAndDate(String username, String date);
}