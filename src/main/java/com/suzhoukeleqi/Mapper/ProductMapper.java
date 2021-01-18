package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.Product;
import com.suzhoukeleqi.entity.ProductListItem;
import com.suzhoukeleqi.entity.ProductMapperRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Product selectProductById(int id);

    List<ProductListItem> selectProductListByListId(int listid);

    List<ProductListItem> selectProductListByclass1(ProductMapperRequest request);

    List<ProductListItem> selectProductListByclass2(ProductMapperRequest request);

    List<ProductListItem> selectAllProducts();

    List<ProductListItem> selectAllProductsPages(ProductMapperRequest request);

    List<Product> selectAllFromProduct();

    List<Product> selectPagesFromProduct(ProductMapperRequest request);
}
