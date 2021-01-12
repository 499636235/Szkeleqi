package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.Product;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    /**
     * 产品详情页面的图片
     *
     * @param id
     * @return
     */
    @RequestMapping("/product/product_detail/{id}")
    @ResponseBody
    public String GetProductDetail(@PathVariable int id) {
        Product product = productService.selectProductById(id);
        return product.getPicture();
    }

    /**
     * 查询全部产品
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/product/all")
    public String selectAllProducts(ModelMap modelMap) {
        List<IndexProduct> indexProductList = productService.selectAllProducts();
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        modelMap.addAttribute("indexProductList", indexProductListJSONArray);
        return "product";
    }

    /**
     * 根据第一种大类查询产品
     *
     * @param class1
     * @param modelMap
     * @return
     */
    @RequestMapping("/product/class1/{class1}")
    public String selectProductListByclass1(@PathVariable String class1, ModelMap modelMap) {
        List<IndexProduct> indexProductList = productService.selectProductListByclass1(class1);
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        modelMap.addAttribute("indexProductList", indexProductListJSONArray);
        return "product";
    }

    /**
     * 根据第二种大类查询产品
     *
     * @param class2
     * @param modelMap
     * @return
     */
    @RequestMapping("/product/class2/{class2}")
    public String selectProductListByclass2(@PathVariable String class2, ModelMap modelMap) {
        List<IndexProduct> indexProductList = productService.selectProductListByclass2(class2);
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        modelMap.addAttribute("indexProductList", indexProductListJSONArray);
        return "product";
    }
}
