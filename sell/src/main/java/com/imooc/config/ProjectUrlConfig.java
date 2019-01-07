package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties( prefix = "projectUrl")
public class ProjectUrlConfig {

    /**
     * 微信公众号平台授权url
     */
    public  String wechatMpAuthorize;

    /**
     * 微信开放号平台授权url
     */
    public  String wechatOpenAuthorize;


    /**
     * 点餐系统
     */
    public String sell;
}
