package com.suzhoukeleqi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListItem {
    private Integer ListIndex;
    private Integer ProductId;
    private String ProductName;
    private String PicturePath;
}
