package com.huihuitf.library.service.impl;

import com.huihuitf.library.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SupplierServiceImplTest {

    @Autowired
    private SupplierService supplierService;
    @Test
    public void queryAllSupplier() {
        System.out.println(supplierService.queryAllSupplier(1,5));

    }
}