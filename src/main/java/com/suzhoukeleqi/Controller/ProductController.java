package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.PageRequest;
import com.suzhoukeleqi.entity.PageResult;
import com.suzhoukeleqi.entity.Product;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * 产品详情页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/product/{id}")
    public String goToProductDetail(@PathVariable int id, Model model) {
        commonModelOperation(model);
        model.addAttribute("id", id);
        return "product_detail";
    }


    /**
     * 产品详情页面的图片
     *
     * @param id
     * @return
     */
    @RequestMapping("/product/product_detail/{id}")
    @ResponseBody
    public String GetProductDetail(@PathVariable int id,Model model) {
        Product product = productService.selectProductById(id);
        return product.getPicture();
    }

    /**
     * 查询全部产品
     *
     * @param model
     * @return
     */
    @RequestMapping("/product/all")
    public String selectAllProducts(Model model) {
        commonModelOperation(model);
        List<IndexProduct> indexProductList = productService.selectAllProducts();
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        model.addAttribute("indexProductList", indexProductListJSONArray);
        return "product";
    }

    /**
     * 分页查询全部产品
     *
     * @param model
     * @return
     */
    @RequestMapping("/product/all/{pageNum}/{pageSize}")
    public String selectPagesFromProduct(PageRequest pageRequest, Model model) {
        commonModelOperation(model);
        model.addAttribute("path", "/product/all/");

        PageResult pageResult = productService.selectAllProductsPages(pageRequest);
        List<IndexProduct> indexProductList = (List<IndexProduct>) pageResult.getContent();
//        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
//        model.addAttribute("indexProductListJSONArray", indexProductListJSONArray);
        model.addAttribute("indexProductList", indexProductList);
        model.addAttribute("pageNum",pageResult.getPageNum());
        model.addAttribute("pageSize",pageResult.getPageSize());
        model.addAttribute("totalPages",pageResult.getTotalPages());
        model.addAttribute("totalSize",pageResult.getTotalSize());
        return "product";
    }

    /**
     * 根据第一种大类查询产品
     *
     * @param class1
     * @param model
     * @return
     */
    @RequestMapping("/product/class1/{class1}")
    public String selectProductListByclass1(@PathVariable String class1, Model model) {
        commonModelOperation(model);
        List<IndexProduct> indexProductList = productService.selectProductListByclass1(class1);
        model.addAttribute("indexProductList", indexProductList);
        return "product";
    }

    /**
     * 根据第二种大类查询产品
     *
     * @param class2
     * @param model
     * @return
     */
    @RequestMapping("/product/class2/{class2}")
    public String selectProductListByclass2(@PathVariable String class2, Model model) {
        commonModelOperation(model);
        List<IndexProduct> indexProductList = productService.selectProductListByclass2(class2);
        model.addAttribute("indexProductList", indexProductList);
        return "product";
    }

    /**
     * 共同 Model 操作
     * @param model
     */
    private void commonModelOperation(Model model){
        model.addAttribute("pagename", "product");
    }
}
