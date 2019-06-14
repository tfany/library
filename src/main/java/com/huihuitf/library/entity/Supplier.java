package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Supplier {
    @Id
    private Integer supplierId;
    private String supplierName;
    private Long phoneNum;
}
