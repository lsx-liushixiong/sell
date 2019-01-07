package com.imooc.dao;

import com.imooc.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDAO extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus (Integer productStatus);
}
