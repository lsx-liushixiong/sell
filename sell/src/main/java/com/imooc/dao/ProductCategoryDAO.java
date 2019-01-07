package com.imooc.dao;

import com.imooc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
