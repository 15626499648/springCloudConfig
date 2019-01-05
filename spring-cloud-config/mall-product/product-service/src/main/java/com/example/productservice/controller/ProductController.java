package com.example.productservice.controller;



import com.example.common.domain.Product;
import com.example.common.domain.User;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.RedisService;
import com.example.productservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name") String name){
        return "这是product服务："+ name;
    }

    @RequestMapping(value = "/showUser")
    public List<User> showUserList(){
    List<User> list = userService.getUserList();
        return list;
}

    @RequestMapping(value="/set/{key}/{value}")
    public String setKey(@PathVariable String key, @PathVariable String value){
        redisService.set(key,value);
        return "set key success!";
    }

    @RequestMapping(value="/get/{key}")
    public String getKey(@PathVariable String key){
        return redisService.get(key);
    }

    @RequestMapping(value="/addProduct")
    public int addProduct(Product product){
        return productService.addProduct(product);
    }

    @RequestMapping(value="/findProductById/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

}