package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @RequestMapping("product/product_detail/{id}")
    @ResponseBody
    public String GetProductDetail(@PathVariable int id){
        Product product = productService.selectProduct(id);
        return product.getPicture();
    }
}
