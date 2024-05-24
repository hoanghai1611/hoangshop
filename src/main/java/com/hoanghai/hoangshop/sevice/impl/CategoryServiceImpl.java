package com.hoanghai.hoangshop.sevice.impl;

import com.hoanghai.hoangshop.domain.Category;
import com.hoanghai.hoangshop.repository.CategoryRepository;
import com.hoanghai.hoangshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository  categoryRespository ;


    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRespository.findAll(pageable);
    }

    @Override
    public <S extends Category> S save(S entity) {
        return categoryRespository.save(entity);
    }

    @Override
    public void deletById(Long id) {
        categoryRespository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRespository.findById(id);

    }

    @Override
    public Page<Category> findByNameContaining(String name, Pageable pageable) {
        return categoryRespository.findByNameContaining(name, pageable);
    }
}

