package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import com.imooc.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by qq132
 * 2018/12/29 15:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PushMessageImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        pushMessageService.orderStatus(orderService.findOne("1545789668954254258"));
    }
}