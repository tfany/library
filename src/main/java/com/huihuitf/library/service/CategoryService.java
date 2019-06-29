package com.huihuitf.library.service;

import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.entity.Category;

import java.util.List;

public interface CategoryService {
    Category queryById(Integer id);
    List<Category> queryAll(Integer parentId);
    Category save(Category category);

    List<CategoryDto> listWithChildren();
}
