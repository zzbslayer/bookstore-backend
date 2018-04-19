package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.model.UserStatusEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatusEntity, Integer > {

    List<UserStatusEntity> findAll();

    UserStatusEntity findByUsername(String username);

    @Modifying
    @Query("update UserEntity u set u.pw = ?1, u.email = ?2 where u.username = ?3")
    void setUserInfoById(String pw, String email, String username);
}
