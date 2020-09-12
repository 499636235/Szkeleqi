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
    public Product selectProduct(int id) {
        return productMapper.selectProduct(id);
    }

    @Override
    public List<IndexProduct> selectIndexProductList() {
        return productMapper.selectIndexProductList();
    }
}
