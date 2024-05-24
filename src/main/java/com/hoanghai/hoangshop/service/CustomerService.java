package com.hoanghai.hoangshop.service;

import com.hoanghai.hoangshop.domain.Category;
import com.hoanghai.hoangshop.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
//    Page<Customer> findByNameContaining(String name, Pageable pageable);
    Page<Customer> findAll(Pageable pageable) ;
    void deletById(Long id);

}
