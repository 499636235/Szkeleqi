package com.suzhoukeleqi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexProduct {
    private Integer priority;
    private Integer product_id;
    private String name;
    private String picture;
}
