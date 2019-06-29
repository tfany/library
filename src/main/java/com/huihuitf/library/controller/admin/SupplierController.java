package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.entity.Supplier;
import com.huihuitf.library.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public CommonResult<List<Supplier>> listSupplier(@RequestParam(value = "pageNum")int pageNum,@RequestParam(value = "pageSize") int pageSize){
        return CommonResult.success(supplierService.queryAllSupplier(pageNum-1,pageSize));
    }
}
