package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    Product selectProduct(int id);
}
