package com.huihuitf.library.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CategoryListDto {
    private Integer total;
    private List<Map<String,Object>> list;
}
