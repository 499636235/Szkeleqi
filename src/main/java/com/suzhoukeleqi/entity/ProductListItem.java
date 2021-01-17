package com.suzhoukeleqi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListItem {
    private Integer listIndex;
    private Integer productId;
    private String productName;
    private String picturePath;
}
