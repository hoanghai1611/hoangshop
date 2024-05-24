package com.hoanghai.hoangshop.repository;

import com.hoanghai.hoangshop.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//  Page<Customer> findByNameContaining(String name, Pageable pageable);
}
