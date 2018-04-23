package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.model.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer > {

    List<UserEntity>findAll();

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
