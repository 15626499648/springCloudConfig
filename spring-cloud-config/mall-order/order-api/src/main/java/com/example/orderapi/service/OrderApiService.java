package com.example.orderapi.service;

import com.example.common.domain.Order;
import com.example.orderapi.hystric.OrderApiServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "order-service",fallback = OrderApiServiceHystric.class)
public interface OrderApiService {

    @RequestMapping(value = "/addOrder")
    public int addOrder(Order order);

}
