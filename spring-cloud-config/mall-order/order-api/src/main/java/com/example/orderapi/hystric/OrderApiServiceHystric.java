package com.example.orderapi.hystric;

import com.example.common.domain.Order;
import com.example.orderapi.service.OrderApiService;
import org.springframework.stereotype.Component;

@Component
public class OrderApiServiceHystric implements OrderApiService {
    @Override
    public int addOrder(Order order) {
        return 0;
    }
}
