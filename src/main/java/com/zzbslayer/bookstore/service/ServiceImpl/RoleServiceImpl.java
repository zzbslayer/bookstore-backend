package com.zzbslayer.bookstore.service.ServiceImpl;

import com.zzbslayer.bookstore.datamodel.dao.RoleRepository;
import com.zzbslayer.bookstore.datamodel.domain.RoleEntity;
import com.zzbslayer.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> findAll(){
        return roleRepository.findAll();
    }

    public List<RoleEntity> findByUsername(String username){
        return roleRepository.findByUsername(username);
    }

    public List<RoleEntity> findByRolename(String rolename){
        return roleRepository.findByRolename(rolename);
    }

    public RoleEntity save(RoleEntity role){
        return roleRepository.save(role);
    }
}
