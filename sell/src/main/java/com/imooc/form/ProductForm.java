package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

@Data
public class ProductForm {

    //ID
    private String productId;

    //名称
    private String productName;

    //价格
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //图片路径
    private String productIcon;

    //类目编号
    private Integer categoryType;

}
