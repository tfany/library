package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.SupplierDao;
import com.huihuitf.library.dto.SupplierDto;
import com.huihuitf.library.entity.Supplier;
import com.huihuitf.library.service.BookService;
import com.huihuitf.library.service.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Autowired
    private BookService bookService;
    @Override
    public List<SupplierDto> queryAllSupplier(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"supplierId");
        Pageable pageable= PageRequest.of(pageNum,pageSize, sort);
        Page<Supplier> supplierPage = supplierDao.findAll(pageable);
        List<Supplier> supplierList =  supplierPage.getContent();
        List<SupplierDto> supplierDtoList=new ArrayList<>();
        for (Supplier supplier : supplierList) {
            SupplierDto supplierDto=new SupplierDto();
            BeanUtils.copyProperties(supplier,supplierDto);
            supplierDto.setCount(bookService.queryCountBySupplier(supplier.getSupplierId()));
            supplierDtoList.add(supplierDto);
        }
        return supplierDtoList;
    }

    @Override
    public int queryTotal() {
        return supplierDao.queryTotal();
    }

    @Override
    public Supplier queryById(int id) {
        return supplierDao.findById(id).orElse(new Supplier());
    }

    @Override
    public Supplier update(Supplier supplier) {
        if(supplier.getSupplierId()!=null){
            supplierDao.save(supplier);
        }
        return new Supplier();
    }

    @Override
    public Supplier save(Supplier supplier) {
        supplier.setSupplierId(supplierDao.getMax()+1);
        return supplierDao.save(supplier);
    }

    @Override
    public void delete(Integer id) {
        supplierDao.deleteById(id);
    }
}
