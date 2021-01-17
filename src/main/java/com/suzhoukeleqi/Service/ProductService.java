package com.suzhoukeleqi.Service;

import com.suzhoukeleqi.entity.*;

import java.util.List;

public interface ProductService {
    Product selectProductById(int id);

    List<ProductListItem> selectProductListByListId(int listid);

    List<ProductListItem> selectProductListByclass1(String class1);

    List<ProductListItem> selectProductListByclass2(String class2);

    List<ProductListItem> selectAllProducts();

    PageResult selectAllProductsPages(PageRequest pageRequest);

    /**
     * 查询全表(后台用)
     *
     * @return
     */
    List<Product> selectAllFromProduct();

    /**
     * 分页查询全表(后台用)
     *
     * @return
     */
    PageResult selectPagesFromProduct(PageRequest pageRequest);
}
