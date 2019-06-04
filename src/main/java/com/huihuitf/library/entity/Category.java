package com.huihuitf.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private String categoryImg;
    private Integer parentId;
}
