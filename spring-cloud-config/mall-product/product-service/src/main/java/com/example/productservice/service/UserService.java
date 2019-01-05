package com.example.productservice.service;

import com.example.common.domain.User;
import com.example.productservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames="user")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "getUserList")
    public List<User> getUserList() {
        return userMapper.getUserList();
    }



}
