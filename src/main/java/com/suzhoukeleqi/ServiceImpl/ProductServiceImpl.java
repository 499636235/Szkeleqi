package com.suzhoukeleqi.ServiceImpl;

import com.suzhoukeleqi.Mapper.ProductMapper;
import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
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
}
