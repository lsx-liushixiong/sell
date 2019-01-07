package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping(value = "/auth")
    public void auth(@RequestParam("code") String code, @RequestParam("state") String state) {
        log.info("进入auth方法。。。");
        log.info("code={},state={}", code, state);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx96e6f3888a18e209&secret=e9af35c62b62d472b1ebff2b4413f45f&code=" + code + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        log.info("response={}", response);
    }
}
