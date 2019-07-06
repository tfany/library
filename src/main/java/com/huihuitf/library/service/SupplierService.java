package com.huihuitf.library.service;

import com.huihuitf.library.dto.SupplierDto;
import com.huihuitf.library.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> queryAllSupplier(int pageNum, int pageSize);
    int queryTotal();
    Supplier queryById(int id);
    Supplier update(Supplier supplier);
    Supplier save(Supplier supplier);
    void delete(Integer id);

}
