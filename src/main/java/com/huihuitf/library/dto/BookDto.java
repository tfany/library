package com.huihuitf.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class BookDto{


    private String bookId;
    private String bookName;
    private String author;
    private Double rent;
    private Double price;
    private Date publicTime;
    private Integer stock;
    private String img;
    private Integer categoryId;
    private Integer parentId;
    private String categoryName;
    private Integer supplierId;
    private String supplierName;
}
