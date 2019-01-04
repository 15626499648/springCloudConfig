package com.example.product.hystric;

import com.example.product.service.ProductApiService;
import org.springframework.stereotype.Component;

@Component
public class ProductApiServiceHystric implements ProductApiService {

    @Override
    public String test(String name) {
        return "error";
    }

}
