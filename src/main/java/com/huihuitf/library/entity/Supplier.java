package com.huihuitf.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Supplier {
    @Id
    private Integer supplierId;
    private String supplierName;
    private Long phoneNum;
}
