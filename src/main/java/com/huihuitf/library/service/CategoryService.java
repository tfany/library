package com.huihuitf.library.service;

import com.huihuitf.library.entity.Category;

import java.util.List;

public interface CategoryService {
    Category queryById(Integer id);
    List<Category> queryAll();
    Category save(Category category);

}
