package com.example.productservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name") String name){
        return "这是product服务："+ name;
    }
}
