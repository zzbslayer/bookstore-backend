package com.zzbslayer.bookstore.service;

import com.zzbslayer.bookstore.datamodel.domain.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> findAll();

    List<RoleEntity> findByUsername(String username);

    List<RoleEntity> findByRolename(String rolename);

    RoleEntity save(RoleEntity role);
}
