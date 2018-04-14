package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer > {

    List<RoleEntity> findAll();

    RoleEntity findByUsername(String username);

    List<RoleEntity> findByRolename(String rolename);
}
