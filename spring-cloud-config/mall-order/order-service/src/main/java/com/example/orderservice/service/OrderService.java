package com.example.orderservice.service;

import com.example.common.domain.Order;
import com.example.common.util.IdUtil;
import com.example.orderservice.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public int addOrder(Order order) {
        order.setId(IdUtil.genGenerateId());
        order.setOrderNumber(IdUtil.getOrderNumberByUUId());
        order.setCreateTime(new Date());
        return orderMapper.insert(order);
    }

}
