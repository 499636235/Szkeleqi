package com.suzhoukeleqi.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suzhoukeleqi.Mapper.ProductMapper;
import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.Utils.PageUtils;
import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.PageRequest;
import com.suzhoukeleqi.entity.PageResult;
import com.suzhoukeleqi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Product selectProductById(int id) {
        return productMapper.selectProductById(id);
    }

    @Override
    public List<IndexProduct> selectIndexProductList() {
        return productMapper.selectIndexProductList();
    }

    @Override
    public List<IndexProduct> selectProductListByclass1(String class1) {
        return productMapper.selectProductListByclass1(class1);
    }

    @Override
    public List<IndexProduct> selectProductListByclass2(String class2) {
        return productMapper.selectProductListByclass2(class2);
    }

    @Override
    public List<IndexProduct> selectAllProducts() {
        return productMapper.selectAllProducts();
    }

    @Override
    public PageResult selectAllProductsPages(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo2(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<IndexProduct> getPageInfo2(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<IndexProduct> indexProductList = productMapper.selectAllProductsPages();
        return new PageInfo<IndexProduct>(indexProductList);
    }

    @Override
    public List<Product> selectAllFromProduct() {
        return productMapper.selectAllFromProduct();
    }

    /**
     * 分页查询全部产品
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult selectPagesFromProduct(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Product> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectPagesFromProduct();
        return new PageInfo<Product>(productList);
    }
}
