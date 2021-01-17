package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.Product;
import com.suzhoukeleqi.entity.ProductListItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductById(int id);

    List<ProductListItem> selectProductListByListId(int listid);

    List<ProductListItem> selectProductListByclass1(String class1);

    List<ProductListItem> selectProductListByclass2(String class2);

    List<ProductListItem> selectAllProducts();

    List<ProductListItem> selectAllProductsPages();

    List<Product> selectAllFromProduct();

    List<Product> selectPagesFromProduct();
}
