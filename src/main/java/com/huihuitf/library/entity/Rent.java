package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rent {
    private Integer rendId;
    private User user;
    private Book book;
    private String rentCount;
    private Date rentTime;
    private Integer duration;
    private Double money;
}
