package com.hoanghai.hoangshop.sevice.impl;


import com.hoanghai.hoangshop.domain.Customer;
import com.hoanghai.hoangshop.repository.CustomerRepository;
import com.hoanghai.hoangshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


//    @Override
//    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
//        return customerRepository.findByNameContaining(name, pageable);
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void deletById(Long id) { customerRepository.deleteById(id);}

    @Override
    public <S extends Customer> S save(S entity) {
        return customerRepository.save(entity);
    }


}




