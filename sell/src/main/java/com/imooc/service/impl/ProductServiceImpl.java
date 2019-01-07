package com.imooc.service.impl;

import com.imooc.dao.ProductInfoDAO;
import com.imooc.dto.CartDTO;
import com.imooc.entity.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Autowired
    private ProductService productService;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDAO.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDAO.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDAO.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDAO.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = productService.findOne(cartDTO.getProductId());

            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //获取商品下单数量
            Integer productQuantity = cartDTO.getProductQuantity();

            //更新
            productInfo.setProductStock(productInfo.getProductStock() + productQuantity);

            productService.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = productInfoDAO.findOne(cartDTO.getProductId());

            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //判断库存是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();

            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            //更新库存
            productInfo.setProductStock(result);

            productInfoDAO.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDAO.findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode()) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoDAO.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDAO.findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoDAO.save(productInfo);
    }
}
