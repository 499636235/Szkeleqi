package com.suzhoukeleqi.Service;

import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.PageRequest;
import com.suzhoukeleqi.entity.PageResult;
import com.suzhoukeleqi.entity.Product;

import java.util.List;

public interface ProductService {
    Product selectProductById(int id);

    List<IndexProduct> selectIndexProductList();

    List<IndexProduct> selectProductListByclass1(String class1);

    List<IndexProduct> selectProductListByclass2(String class2);

    List<IndexProduct> selectAllProducts();

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
