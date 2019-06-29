package com.huihuitf.library.service.impl;

import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void queryById() {
        Assert.assertEquals(categoryService.queryById(1).getCategoryId(),Integer.valueOf(1));
    }

    @Test
    public void queryAll() {
        Assert.assertEquals(categoryService.queryAll(1).size(),4);
    }

    @Test
    public void save() {
        Category category =new Category();
        category.setCategoryName("色情书籍");
        categoryService.save(category);
        System.out.println(category);
    }
    @Test
    public void listWithChildren(){
        List<CategoryDto> list = categoryService.listWithChildren();
        System.out.println(list);
    }
}