package com.huihuitf.library.dto;

import lombok.Data;

@Data
public class HistoryDto {
    private String bookId;
    private Long userId;
    private int rentDay;
    private int rentCount;
    private double money;
}
