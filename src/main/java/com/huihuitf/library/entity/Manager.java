package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Manager {
    @Id
    private Integer managerId;
    private String managerName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
