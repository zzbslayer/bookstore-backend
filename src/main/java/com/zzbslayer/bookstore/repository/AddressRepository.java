package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findByUsername(String username);
}
