package com.imooc.entity.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qq132
 * 2019/1/10 10:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insert() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "必点");
        map.put("type", 2);
        int count = mapper.insert(map);
        Assert.assertEquals(1, count);
    }
}