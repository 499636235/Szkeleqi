package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.Product;
import com.suzhoukeleqi.entity.ProductListItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductById(int id);

    List<ProductListItem> selectProductListByListId(HashMap map);

    List<ProductListItem> selectProductListByclass1(HashMap map);

    List<ProductListItem> selectProductListByclass2(HashMap map);

    List<ProductListItem> selectAllProductsPages(HashMap map);

    List<Product> selectPagesFromProduct(HashMap map);
}
