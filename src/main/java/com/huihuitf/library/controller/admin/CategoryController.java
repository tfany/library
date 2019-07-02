package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.dto.CategoryDto;
import com.huihuitf.library.dto.CategoryListDto;
import com.huihuitf.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
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
    public CommonResult<CategoryListDto> listCategory(@PathVariable Integer parentId,int pageNum, int pageSize) {
        CategoryListDto list = categoryService.queryAll(parentId,pageNum-1,pageSize);
        return CommonResult.success(list);
    }
}
