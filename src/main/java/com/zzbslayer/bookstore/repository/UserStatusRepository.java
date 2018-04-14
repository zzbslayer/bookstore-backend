package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.domain.UserStatusEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatusEntity, Integer > {

    List<UserStatusEntity> findAll();

    UserStatusEntity findByUsername(String username);
}
