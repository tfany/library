package com.huihuitf.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Rank {
    @Id
    private Integer level;
    private String name;
    private Double discount;
}
