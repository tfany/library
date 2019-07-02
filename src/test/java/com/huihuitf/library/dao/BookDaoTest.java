package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void queryBookByBookNameLike() {
    }

    @Test
    public void queryTotal() {
    }

    @Test
    public void deleteBooksByBookIdLike() {
    }

    @Test
    public void queryBooksByBookCategory() {
        Category category=new Category();
        category.setCategoryId(18);
        List list =bookDao.queryBooksByBookCategory_CategoryId(category.getCategoryId());
        System.out.println(list.size());
    }
}