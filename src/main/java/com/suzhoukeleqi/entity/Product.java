package com.suzhoukeleqi.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productClass1;
    private String productClass2;
    private String productClass3;
    private String productName;
    private String pictureName;
    private String picturePath;
    private String createDate;
    private String updateDate;
}
