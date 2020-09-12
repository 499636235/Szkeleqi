package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProduct(int id);
    List<IndexProduct> selectIndexProductList();
}
