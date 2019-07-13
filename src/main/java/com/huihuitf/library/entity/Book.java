package com.huihuitf.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
@Data
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
    private Date publicTime;
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;
    private Integer stock;
    private String img;

    public Book() {
    }
    public Book(String bookId) {
        this.setBookId(bookId);
    }
}
