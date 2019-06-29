package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
public class Book {
    @Id
    private String bookId;
    @ManyToOne
    @JoinColumn(name = "book_category")
    private Category bookCategory;
    private String bookName;
    private String author;
    private Double rent;
    private Double price;
    private String publisher;
    private Date public_time;
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;
    private Integer stock;
    private String img;
}
