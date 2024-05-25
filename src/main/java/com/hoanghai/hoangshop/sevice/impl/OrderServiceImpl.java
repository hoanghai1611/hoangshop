package com.hoanghai.hoangshop.sevice.impl;

import com.hoanghai.hoangshop.domain.Order;
import com.hoanghai.hoangshop.repository.OrderRepository;
import com.hoanghai.hoangshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Page<Order> findByNameContaining(String name1, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
