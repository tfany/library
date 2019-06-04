package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}

