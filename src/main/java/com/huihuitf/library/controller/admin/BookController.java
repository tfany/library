package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.dto.BookDto;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.service.BookService;
import com.huihuitf.library.service.CategoryService;
import com.huihuitf.library.util.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    CommonResult bookList(int pageNum,
                          int pageSize,
                          @RequestParam(value = "productSn",required = false) String bookId,
                          @RequestParam(value = "keyword",required = false) String bookName,
                          @RequestParam(value = "productCategoryId",required = false) Integer categoryId,
                          @RequestParam(value = "brandId",required = false)Integer supplierId) {
        Map<String, Object> list=new HashMap<>();
        Page<Book> page=bookService.findAllBook(pageNum - 1, pageSize,bookId,bookName,categoryId,supplierId);
        PageHelp.pageDeal(pageNum, pageSize,(int) page.getTotalElements(),list);
        list.put("list", page.getContent());
        return CommonResult.success(list);
    }


    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody

    public CommonResult getUpdateInfo(@PathVariable String id) {
        BookDto bookResult = bookService.queryBookById(id);
        return CommonResult.success(bookResult);
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody

    public CommonResult update(@PathVariable String id, @RequestBody BookDto bookParam) {

        if (!id.equals(bookParam.getBookId())) {
            return CommonResult.failed("不要乱改导航地址哦");
        }

        if (bookService.updateBook(bookParam) == 1)
            return CommonResult.success(null);
        return CommonResult.failed("网络不佳，请重试");
    }

    @PostMapping("/update/deleteStatus")
    public CommonResult delete(@RequestParam("ids") String id,@RequestParam("deleteStatus") Integer deleteStatus){
        if(deleteStatus==1 &&bookService.deleteBook(id)==1){
            return CommonResult.success(null);
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/create")
    public CommonResult<Book> create(@RequestBody BookDto bookParam ) {
        if (bookService.saveBook(bookParam) == 1)
            return CommonResult.success(null);
        return CommonResult.failed("网络不佳，请重试");
    }

    @RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
    @ResponseBody

    public CommonResult upload(@PathVariable String id, @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            String imgUrl = bookService.addFace(id, file);

            return CommonResult.success(imgUrl);

        } catch (Exception e) {
            return CommonResult.failed();
        }
    }


//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//
//    public CommonResult<CommonPage<Book>> getList(PmsProductQueryParam productQueryParam,
//                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(productList));
//    }


    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Book>> getList(String keyWord) {
        List<Book> productList = bookService.queryBookByNameOrAuthor(keyWord);
        return CommonResult.success(productList);
    }

    @GetMapping(value = "/getNoParent/{id}")
    public CommonResult getNoParent(@PathVariable int id){
        List<Book> bookList;
        bookList=categoryService.queryBookByCategoryParent(id);
        return CommonResult.success(bookList);
    }

    @GetMapping(value = "/getByParent/{id}")
    public CommonResult getByParent(@PathVariable int id){
        List<Book> bookList;
        bookList=bookService.queryBookByCategory(id);
        return CommonResult.success(bookList);
    }


}
