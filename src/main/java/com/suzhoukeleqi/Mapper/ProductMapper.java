package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductById(int id);

    List<IndexProduct> selectIndexProductList();

    List<IndexProduct> selectProductListByclass1(String class1);

    List<IndexProduct> selectProductListByclass2(String class2);

    List<IndexProduct> selectAllProducts();

    List<Product> selectAllFromProduct();

    List<Product> selectPagesFromProduct();
}
