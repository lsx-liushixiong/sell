package com.imooc.service.impl;

import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.RedisLock;
import com.imooc.service.SeckillService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qq132
 * 2019/1/10 11:27
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private static final int TIMEOUT = 10 * 1000; //超时时间10S

    @Autowired
    private RedisLock redisLock;

    /**
     * 国庆活动,皮蛋粥特价，限量100000份
     */
    static Map<String,Integer> products;

    static Map<String,Integer> stock;

    static Map<String,String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 1000000);
    }

    private String queryMap(String productId)
    {
        return  "国庆活动，皮蛋粥特价，限量："+products.get(productId)+"份，" +
                "还剩："+ stock.get(productId)+"份，" +
                "该商品成功下单用户数目："+orders.size()+"人";
    }


    @Override
    public String querySeckillProductInfo(String productId)
    {
        return this.queryMap(productId);
    }

    @Override
    public  void orderProductMockDiffUser(String productId)
    {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(ResultEnum.TIME_OUT);
        }

        //查询该商品，为0则活动结束
        int stockNum = stock.get(productId);
        if(stockNum == 0) {
            throw new SellException(ResultEnum.STOCK_NULL);
        }else {
            //下单(模拟不同用户openid不同)
            orders.put(KeyUtil.genUniqueKey(), productId);
            //减库存
            stockNum = stockNum-1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
