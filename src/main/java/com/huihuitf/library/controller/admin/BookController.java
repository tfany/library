package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    CommonResult booklist(int pageNum,int pageSize){
        int total = bookService.queryTotal();
        int totalPage=total/pageSize;
        if(total%pageSize!=0){
            totalPage++;
        }
        Map<String,Object> list=new HashMap<>();
        list.put("pageNum",pageNum);
        list.put("pageSize",pageSize);
        list.put("total",total);
        list.put("totalPage",totalPage);
        list.put("list",bookService.findAllBook(pageNum-1,pageSize));
        return CommonResult.success(list);
    }
}
