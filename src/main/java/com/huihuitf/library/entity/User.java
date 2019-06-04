package com.huihuitf.library.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    private Long userId;
    private String name;
    private String gender;
    private String password;
    private String phoneNum;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String headImg;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "rank",referencedColumnName = "level")
    private Rank rank;

}
