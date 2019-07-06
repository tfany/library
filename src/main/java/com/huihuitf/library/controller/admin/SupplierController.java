package com.huihuitf.library.controller.admin;

import com.huihuitf.library.api.CommonResult;
import com.huihuitf.library.entity.Supplier;
import com.huihuitf.library.service.SupplierService;
import com.huihuitf.library.util.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public CommonResult listSupplier(@RequestParam(value = "pageNum")int pageNum,@RequestParam(value = "pageSize") int pageSize){
        Map<String, Object> map=new HashMap<>();
        PageHelp.pageDeal(pageNum, pageSize, supplierService.queryTotal(),map);
        map.put("list",supplierService.queryAllSupplier(pageNum-1,pageSize));
        return CommonResult.success(map);
    }

    @GetMapping("/{id}")
    public CommonResult queryById(@PathVariable int id){
        return CommonResult.success(supplierService.queryById(id));
    }

    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable int id, @RequestBody Supplier supplier){
        if(id!=supplier.getSupplierId()){
            return CommonResult.failed("不要修改状态栏参数!!!!!");
        }
        supplierService.update(supplier);
        return CommonResult.success(supplierService.queryById(id));
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Supplier supplier){
        supplierService.save(supplier);
        return CommonResult.success(null);
    }

    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        supplierService.delete(id);
        return CommonResult.success(null);
    }
}
