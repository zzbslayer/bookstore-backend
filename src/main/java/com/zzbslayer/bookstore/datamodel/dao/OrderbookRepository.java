package com.zzbslayer.bookstore.datamodel.dao;

import com.zzbslayer.bookstore.datamodel.domain.OrderbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderbookRepository extends JpaRepository<OrderbookEntity, Integer > {

    List<OrderbookEntity> findByOrderid(Integer orderid);

    List<OrderbookEntity> findByBookid(Integer bookid);

}
