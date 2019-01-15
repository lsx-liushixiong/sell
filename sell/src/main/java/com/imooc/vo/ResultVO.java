package com.imooc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * HTTP请求返回的最外层对象
 */

@Data
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = -8349181922768084604L;
    //提示码
    private Integer code;

    //提升信息
    private String msg;

    //具体内容
    private T data;
}