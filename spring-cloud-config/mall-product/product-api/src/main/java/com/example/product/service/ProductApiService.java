package com.example.product.service;

import com.example.product.hystric.ProductApiServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service",fallback = ProductApiServiceHystric.class)
public interface ProductApiService {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);

}
