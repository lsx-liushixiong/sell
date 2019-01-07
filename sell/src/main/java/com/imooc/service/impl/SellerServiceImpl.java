package com.imooc.service.impl;

import com.imooc.dao.SellerInfoDAO;
import com.imooc.entity.SellerInfo;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDAO sellerInfoDAO;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDAO.findByOpenid(openid);
    }
}
