package com.suzhoukeleqi.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer ProductId;
    private String ProductClass1;
    private String ProductClass2;
    private String ProductClass3;
    private String ProductName;
    private String PictureName;
    private String PicturePath;
    private String CreateDate;
    private String UpdateDate;
}
