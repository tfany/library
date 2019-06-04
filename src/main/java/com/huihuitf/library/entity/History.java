package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class History {
    private Integer historyId;
    private Book book;
    private User user;
    private Date rentTime;
    private Date remandTime;
    private Double money;
    private Integer num;
    private Integer status;
}
