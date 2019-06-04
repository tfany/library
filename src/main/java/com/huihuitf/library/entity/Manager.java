package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Manager {
    private Integer managerId;
    private String managerName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
