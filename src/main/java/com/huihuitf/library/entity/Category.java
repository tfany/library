package com.huihuitf.library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id
    private Integer categoryId;
    private String categoryName;
    private String categoryImg;
    private Integer parentId;
    private String description;
}
