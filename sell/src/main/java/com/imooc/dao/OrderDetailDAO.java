package com.imooc.dao;

import com.imooc.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);

    List<OrderDetail> findByProductId(String productId);
}
