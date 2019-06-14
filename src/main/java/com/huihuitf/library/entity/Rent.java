package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Rent {
    @Id
    private Integer rendId;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;
    private String rentCount;
    private Date rentTime;
    private Integer duration;
    private Double money;
}
