package com.hoanghai.hoangshop.service;

import com.hoanghai.hoangshop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
}
