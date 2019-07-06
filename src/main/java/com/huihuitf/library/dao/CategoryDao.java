package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    List<Category> queryAllByParentId(Integer parent);
    List<Category> queryAllByParentId(Integer parent, Pageable page);
    @Query("SELECT MAX(categoryId) from Category")
    Integer queryMaxCategoryId();
    int deleteCategoriesByParentId(Integer parentId);
}

