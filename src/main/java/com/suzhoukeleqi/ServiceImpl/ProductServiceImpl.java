package com.suzhoukeleqi.ServiceImpl;

import com.suzhoukeleqi.Mapper.ProductMapper;
import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper ProductMapper;

    @Override
    public Product selectProduct(int id) {
        return ProductMapper.selectProduct(id);
    }
}
