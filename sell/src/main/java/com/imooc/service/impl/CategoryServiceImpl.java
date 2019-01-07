package com.imooc.service.impl;

import com.imooc.dao.ProductCategoryDAO;
import com.imooc.entity.ProductCategory;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDAO categoryDAO;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryDAO.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryDAO.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryDAO.save(productCategory);
    }
}
