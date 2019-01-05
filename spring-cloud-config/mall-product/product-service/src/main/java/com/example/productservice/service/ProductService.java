package com.example.productservice.service;

import com.example.common.domain.Product;
import com.example.productservice.mapper.ProductMapper;
import com.example.common.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@CacheConfig(cacheNames="productCache")
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public int addProduct(Product product) {
        product.setId(IdUtil.genGenerateId());
        product.setCreateTime(new Date());
        return productMapper.insert(product);
    }

    @Cacheable(value="product", key="#id")
    public Product findProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }


}
