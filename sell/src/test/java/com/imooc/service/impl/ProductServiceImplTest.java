package com.imooc.service.impl;

import com.imooc.entity.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        System.out.println(productInfo.toString());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> all = productService.findUpAll();
        System.out.println(all.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> all = productService.findAll(request);
        System.out.println(all.getSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(2.8));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃！！！");
        productInfo.setProductIcon("HTPP://XXXX.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = productService.onSale("123456");
        System.out.println(productInfo.toString());
    }

    @Test
    public void offSale() {
        ProductInfo productInfo = productService.offSale("123456");
        System.out.println(productInfo.toString());
    }
}