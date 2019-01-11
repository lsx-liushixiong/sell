package com.imooc.controller;

import com.imooc.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qq132
 * 2019/1/11 9:38
 * 秒杀活动
 */
@RestController
@Slf4j
@RequestMapping("/skill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId)
    {
        return seckillService.querySeckillProductInfo(productId);
    }



    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId)
    {
        log.info("@skill request, productId:" + productId);
        seckillService.orderProductMockDiffUser(productId);
        return seckillService.querySeckillProductInfo(productId);
    }
}
