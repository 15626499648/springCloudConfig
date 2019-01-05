package com.example.demo.controller;

import com.example.common.domain.Order;
import com.example.demo.service.SchedualServiceHi;

import com.example.orderapi.service.OrderApiService;
import com.example.product.service.ProductApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    public ProductApiService productApiService;

    @Autowired
    public OrderApiService orderApiService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam String name) {
        return productApiService.test(name);
    }

    @GetMapping(value = "/testAdd/{productId}/{amount}")
    public String testAdd(@PathVariable Long productId, @PathVariable int amount) {
        Order order = new Order();
        order.setProductId(productId);
        order.setAmount(amount);
        int row = orderApiService.addOrder(order);
        System.out.println(row);
        return "成功";
    }

}