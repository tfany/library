package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    List<Category> queryAllByParentId(Integer parent);
    @Query("SELECT MAX(categoryId) from Category")
    Integer queryMaxCategoryId();
}

