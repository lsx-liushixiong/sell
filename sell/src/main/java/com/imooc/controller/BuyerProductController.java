package com.imooc.controller;

import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVO;
import com.imooc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123", unless = "#result.getCode() != 0")
    public ResultVO list() {

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目(一次性查询)
/*        for (ProductInfo productInfo:productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());
        //根据typeList类目编号查询所有类目
        List<ProductCategory> productCategoryTypeList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryTypeList) {
            ProductVO productVO = new ProductVO();
/*            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());*/
            BeanUtils.copyProperties(productCategory, productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
