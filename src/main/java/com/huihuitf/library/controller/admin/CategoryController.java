package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.dto.CategoryListDto;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CategoryDto>> listWithChildren() {
        List<CategoryDto> list = categoryService.listWithChildren();
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CategoryListDto> listCategory(@PathVariable Integer parentId, int pageNum, int pageSize) {
        CategoryListDto list = categoryService.queryAll(parentId, pageNum - 1, pageSize);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult categoryInfo(@PathVariable Integer id) {
        Category category = categoryService.queryById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", category.getCategoryName());
        map.put("parentId", category.getParentId());
        map.put("categoryImg", category.getCategoryImg());
        map.put("description", category.getDescription());
        map.put("categoryId", category.getCategoryId());

        return CommonResult.success(map);
    }


    @PostMapping(value = "upload/{id}")
    public CommonResult upload(@PathVariable Integer id, MultipartFile file) {
        try {

            String imgUrl = categoryService.addCategoryFace(id, file);
            return CommonResult.success(imgUrl);

        } catch (Exception e) {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "update/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Category category) {
        if (!category.getCategoryId().equals(id)) {
            CommonResult.failed("说了别改导航栏啊!!");
        }
        if(categoryService.update(category)==1)
            return CommonResult.success(null);
        return CommonResult.failed("更新失败");

    }

    @PostMapping(value = "/create")
    public CommonResult create( @RequestBody Category category) {

        categoryService.save(category);

        return CommonResult.success(null);
    }

    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        int count = categoryService.delete(id);
        if(count!=0){
            return CommonResult.success(null);
        }else {
            return CommonResult.failed("删除失败");
        }
    }


}
