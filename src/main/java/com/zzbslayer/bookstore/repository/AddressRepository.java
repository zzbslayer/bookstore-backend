package com.zzbslayer.bookstore.repository;

import com.zzbslayer.bookstore.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findAll();

    List<AddressEntity> findByUsername(String username);

    AddressEntity findByAddressid(Integer addressid);

    AddressEntity findByUsernameAndShippingaddressAndRecipientAndPhone(String username,String shippingaddress,String recipient,String phone);
}
