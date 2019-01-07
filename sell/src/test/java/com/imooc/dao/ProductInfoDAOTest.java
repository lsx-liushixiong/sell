package com.imooc.dao;

import com.imooc.entity.ProductInfo;
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
public class ProductInfoDAOTest {
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("888888");
        productInfo.setProductName("小龙虾");
        productInfo.setProductPrice(new BigDecimal(58.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("超好吃！！！");
        productInfo.setProductIcon("HTPP://XXXX.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        productInfoDAO.save(productInfo);
    }

    @Test
    public void updateTest(){
/*        ProductInfo productInfo = productInfoDAO.findOne("232323");
        productInfo.setCategoryType(2);
        productInfoDAO.save(productInfo);*/
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> prodecutInfoList = productInfoDAO.findByProductStatus(0);
        Assert.assertNotEquals(0,prodecutInfoList.size());
    }
}