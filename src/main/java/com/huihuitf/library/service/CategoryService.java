package com.huihuitf.library.service;

import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.dto.CategoryListDto;
import com.huihuitf.library.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    Category queryById(Integer id);
    List<Category> queryAll(Integer parentId);
    Category save(Category category);
    int update(Category category);
    int queryBookByCategoryParent(int parent);
    CategoryListDto queryAll(Integer parentId, int pageNum, int pageSize);
    List<CategoryDto> listWithChildren();
    String addCategoryFace(int category, MultipartFile file);
}
