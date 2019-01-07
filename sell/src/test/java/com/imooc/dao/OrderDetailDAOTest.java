package com.imooc.dao;

import com.imooc.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDAOTest {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("987654321");
        orderDetail.setOrderId("111222");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("111222");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal( 2.2));
        orderDetail.setProductQuantity(3);
        OrderDetail result = orderDetailDAO.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDAO.findByOrderId("111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

    @Test
    public void findByProductId() {
        List<OrderDetail> orderDetailList = orderDetailDAO.findByProductId("111222");
        System.out.println(orderDetailList.size());
    }
}