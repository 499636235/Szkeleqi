package com.suzhoukeleqi.Service;

import com.suzhoukeleqi.entity.*;

import java.util.List;

public interface ProductService {
    /**
     * 根据产品的 id 查询产品
     * @param id
     * @return
     */
    Product selectProductById(int id);

    /**
     * 根据列表的 id 查询产品图片列表
     * @param listid
     * @return
     */
    List<ProductListItem> selectProductListByListId(int listid);

    /**
     * 根据分类 class1 查询产品
     * @param pageRequest
     * @param class1
     * @return
     */
    PageResult selectProductListByclass1(PageRequest pageRequest, String class1);

    /**
     * 根据分类 class2 查询产品
     * @param pageRequest
     * @param class2
     * @return
     */
    PageResult selectProductListByclass2(PageRequest pageRequest, String class2);

    /**
     * 分页查询全部产品
     * @param pageRequest
     * @return
     */
    PageResult selectAllProductsPages(PageRequest pageRequest);

    /**
     * 分页查询全表(后台用)
     *
     * @return
     */
    PageResult selectPagesFromProduct(PageRequest pageRequest);
}
