package com.example.orderservice.controller;
import com.example.common.domain.Order;
import com.example.common.domain.Product;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/addOrder")
    public int addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

}