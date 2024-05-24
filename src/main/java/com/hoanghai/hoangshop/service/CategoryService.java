package com.hoanghai.hoangshop.service;

import com.hoanghai.hoangshop.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CategoryService {
    Page<Category> findAll(Pageable pageable) ;
    <S extends Category > S save(S entity);
 void deletById(Long id);
 Optional<Category> findById(Long id);
 Page<Category> findByNameContaining(String name,Pageable pageable);
}
