package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 消息推送
 * Created by qq132
 * 2018/12/29 13:53
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
