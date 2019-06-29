package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.CategoryDao;
import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category queryById(Integer id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public List<Category> queryAll(Integer parentId) {

        return categoryDao.queryAllByParentId(parentId);

    }

    @Override
    public Category save(Category category) {
        category.setCategoryId(categoryDao.queryMaxCategoryId()+1);
        return categoryDao.save(category);
    }

    @Override
    public List<CategoryDto> listWithChildren() {

        List<CategoryDto> categoryDtoList=new ArrayList<>();
        //查询所有一级目录
        List<Category> oneCategory=queryAll(null);
        for (Category category : oneCategory) {
            CategoryDto temp=new CategoryDto() ;
            temp.setCategoryId(category.getCategoryId());
            temp.setCategoryName(category.getCategoryName());
            temp.setCategoryImg(category.getCategoryImg());
            temp.setChildren(queryAll(category.getCategoryId()));
            categoryDtoList.add(temp);
        }
        return categoryDtoList;
    }
}
