package com.suzhoukeleqi.Service;

import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.Product;

import java.util.List;

public interface ProductService {
    Product selectProduct(int id);

    List<IndexProduct> selectIndexProductList();

    List<IndexProduct> selectProductListByclass1(String class1);

    List<IndexProduct> selectProductListByclass2(String class2);
}
