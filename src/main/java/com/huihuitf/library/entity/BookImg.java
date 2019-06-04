package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookImg {
    private Integer bookImgId;
    private Book book;
    private String address;
    private String description;
}
