package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class History {
    @Id
    private String historyId;
    @ManyToOne
    @JoinColumn(name="book")
    private Book book;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    private Date rentTime;
    private Date remandTime;
    private Double money;
    private Integer num;
    private Integer status;
    //借了多久
    private Integer time;
}
