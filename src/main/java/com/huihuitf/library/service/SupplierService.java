package com.huihuitf.library.service;

import com.huihuitf.library.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> queryAllSupplier(int pageNum,int pageSize);
}
