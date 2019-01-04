package com.example.productservice.controller;


import com.example.productservice.model.User;
import com.example.productservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name") String name){
        return "这是product服务："+ name;
    }

    @RequestMapping(value = "/showUser")
    public List<User> showUserList(){
        List<User> list = userService.getUserList();
        return list;

    }
}
