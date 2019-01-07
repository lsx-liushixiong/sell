package com.imooc.dao;

import com.imooc.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDAO extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
