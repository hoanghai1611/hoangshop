package com.hoanghai.hoangshop.service;

import com.hoanghai.hoangshop.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<Order> findByNameContaining(String name1, Pageable pageable);

    Page<Order> findAll(Pageable pageable);
}
