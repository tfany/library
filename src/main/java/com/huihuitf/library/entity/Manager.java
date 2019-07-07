package com.huihuitf.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Manager {
    @Id
    private Long managerId;
    private String managerName;
    private String password;
    private String headImg;
}
