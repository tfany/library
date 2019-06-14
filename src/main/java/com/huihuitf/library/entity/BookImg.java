package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class BookImg {
    @Id
    private Integer bookImgId;
    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;
    private String address;
    private String description;
}
