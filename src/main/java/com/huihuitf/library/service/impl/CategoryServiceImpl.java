package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.BookDao;
import com.huihuitf.library.dao.CategoryDao;
import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.dto.CategoryListDto;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.CategoryService;
import com.huihuitf.library.util.ImageUtil;
import com.huihuitf.library.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public Category queryById(Integer id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public List<Category> queryAll(Integer parentId) {
        return categoryDao.queryAllByParentId(parentId);
    }

    @Override
    public List<Book> queryBookByCategoryParent(int parent) {
        List<Book> bookList = new ArrayList<>();
        //得到所有子类
        List<Category> categoryList=categoryDao.queryAllByParentId(parent);

        //遍历子分类 查找book
        for(Category category: categoryList){
            bookList.addAll(bookDao.queryBooksByBookCategory_CategoryId(category.getCategoryId()));
        }
        return bookList;
    }

    @Override
    public Category save(Category category) {
        category.setCategoryId(categoryDao.queryMaxCategoryId()+1);
        if(!category.getCategoryImg().equals(""))
            PathUtil.deleteFiles(category.getCategoryImg());
        return categoryDao.save(category);
    }

    @Override
    public int delete(Integer id) {

        try {
            Category category = categoryDao.findById(id).orElse(new Category());
            //删除所有子分类
            if (category.getCategoryId() != null && category.getParentId() == null) {
                categoryDao.deleteCategoriesByParentId(category.getCategoryId());
            }
            categoryDao.deleteById(category.getCategoryId());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int update(Category category) {
       try{
           if(categoryDao.existsById(category.getCategoryId())){
               categoryDao.save(category);
               if(!category.getCategoryImg().equals(""))
                   PathUtil.deleteFiles(category.getCategoryImg());
               return 1;
           }

           return 0;
       }catch (Exception e){
           return 0;
       }
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



    /**
     *分页返回
     * @param parentId id
     * @param pageNum num
     * @param pageSize size
     * @return list
     */
    @Override
    public CategoryListDto queryAll(Integer parentId, int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"categoryId");
        Pageable pageable= PageRequest.of(pageNum,pageSize, sort);
        CategoryListDto categoryListDto = new CategoryListDto();

        if(parentId==0) {
            categoryListDto.setTotal(categoryDao.queryAllByParentId(null).size());
            List<Map<String,Object>> list=new ArrayList<>();
            for(Category category: categoryDao.queryAllByParentId(null,pageable)){
                Map<String,Object> map=new HashMap<>();
                map.put("id",category.getCategoryId());
                map.put("name",category.getCategoryName());
                map.put("level", 0);
                map.put("bookCount",queryBookByCategoryParent(category.getCategoryId()).size());
                list.add(map);
            }
            categoryListDto.setList(list);

        }
        else{
            categoryListDto.setTotal(categoryDao.queryAllByParentId(parentId).size());
            List<Map<String,Object>> list=new ArrayList<>();

            for(Category category: categoryDao.queryAllByParentId(parentId,pageable)){
                Map<String,Object> map=new HashMap<>();
                map.put("id",category.getCategoryId());
                map.put("name",category.getCategoryName());
                map.put("level", 1);
                map.put("bookCount",bookDao.queryBooksByBookCategory_CategoryId(category.getCategoryId()).size());
                list.add(map);
            }
            categoryListDto.setList(list);

        }
        return categoryListDto;
    }

    public String addCategoryFace(int category, MultipartFile file) {
        if(file!=null) {
            if(category==-1){
                category=categoryDao.queryMaxCategoryId()+1;
            }
            //获取存放路径
            String dest = PathUtil.getCategoryPath(category);
            //返回存放地址
            return ImageUtil.generateThumbnail(file, dest);
        }
        return null;
    }

}
