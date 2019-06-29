package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.SupplierDao;
import com.huihuitf.library.entity.Supplier;
import com.huihuitf.library.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Override
    public List<Supplier> queryAllSupplier(int pageNum,int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"supplierId");
        Pageable pageable= PageRequest.of(pageNum,pageSize, sort);
        Page<Supplier> supplierPage = supplierDao.findAll(pageable);
        return supplierPage.getContent();
    }
}
