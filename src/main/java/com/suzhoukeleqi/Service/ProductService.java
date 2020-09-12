package com.suzhoukeleqi.Service;

import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.Product;

import java.util.List;

public interface ProductService {
    Product selectProduct(int id);
    List<IndexProduct> selectIndexProductList();
}
