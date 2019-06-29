package com.huihuitf.library.dto;

import com.huihuitf.library.entity.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryDto extends Category {
    private List<Category> children;
}
