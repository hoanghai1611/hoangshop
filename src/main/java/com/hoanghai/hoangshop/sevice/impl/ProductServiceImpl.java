package com.hoanghai.hoangshop.sevice.impl;

import com.hoanghai.hoangshop.domain.Product;
import com.hoanghai.hoangshop.repository.CustomerRepository;
import com.hoanghai.hoangshop.repository.ProductRepository;
import com.hoanghai.hoangshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
