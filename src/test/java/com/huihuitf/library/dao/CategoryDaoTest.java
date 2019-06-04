package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryRepository;

    @Test
    public void findOneTest(){
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("历史");
        categoryRepository.save(category);
        System.out.println(category);
    }
}