package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierDao extends JpaRepository<Supplier,Integer> {

    @Query("select count (supplierId) from Supplier ")
    int queryTotal();

    @Query("select max(supplierId) from Supplier")
    int getMax();
}
