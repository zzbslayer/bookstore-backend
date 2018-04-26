package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findAll();

    List<AddressEntity> findByUsername(String username);

    AddressEntity findByAddressid(Integer addressid);

    AddressEntity findByUsernameAndShippingaddressAndRecipientAndPhone(String username,String shippingaddress,String recipient,String phone);

}
