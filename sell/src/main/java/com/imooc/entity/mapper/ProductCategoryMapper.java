package com.imooc.entity.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

/**
 * Created by qq132
 * 2019/1/10 10:05
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name, category_type) VALUES (#{name}, #{type})")
    int insert(Map<String, Object> map);

}
