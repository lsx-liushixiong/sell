package com.imooc.dao;

import com.imooc.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDAOTest {
    @Autowired
    private OrderMasterDAO orderMasterDAO;

    private final String OPENID = "110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("654321");
        orderMaster.setBuyerName("大大");
        orderMaster.setBuyerPhone("161161");
        orderMaster.setBuyerAddress("五一广场");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = orderMasterDAO.save(orderMaster);
        System.out.println(result.toString());
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(1,3);
        Page<OrderMaster> result = orderMasterDAO.findByBuyerOpenid(OPENID,request);
        Assert.assertNotNull(result.getTotalElements());
    }
}