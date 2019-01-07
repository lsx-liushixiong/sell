package com.imooc.dao;

import com.imooc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDAOTest {
    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDAO.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        ProductCategory result = productCategoryDAO.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByIdsTest(){
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> result = productCategoryDAO.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}