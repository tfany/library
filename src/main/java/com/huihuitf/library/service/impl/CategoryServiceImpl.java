package com.huihuitf.library.service.impl;

import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Category queryById(Integer id) {
        return null;
    }

    @Override
    public List<Category> queryAll() {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}
