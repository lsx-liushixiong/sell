package com.imooc.dao;

import com.imooc.entity.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoDAOTest {
    @Autowired
    private SellerInfoDAO sellerInfodao;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo result = sellerInfodao.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid(){
        SellerInfo sellInfo = sellerInfodao.findByOpenid("abc");
        Assert.assertEquals("abc", sellInfo.getOpenid());
    }
}