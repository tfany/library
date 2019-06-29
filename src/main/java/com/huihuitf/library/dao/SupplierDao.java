package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier,Integer> {
}
