package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Book {
    private Long bookId;
    private Category bookCategory;
    private String bookName;
    private String author;
    private Double rent;
    private Double price;
    private Double publisher;
    private Date public_time;
    private Supplier supplier;
    private Integer stock;
}
