package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.PageRequest;
import com.suzhoukeleqi.entity.PageResult;
import com.suzhoukeleqi.entity.Product;
import com.suzhoukeleqi.entity.ProductListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        Product product = productService.selectProductById(id);
        model.addAttribute("product", product);
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
    public String GetProductDetail(@PathVariable int id, Model model) {
        Product product = productService.selectProductById(id);
        return product.getPicturePath();
    }

    /**
     * 分页查询全部产品
     *
     * @param model
     * @return
     */
//    @RequestMapping("/product/all/{pageNum}/{pageSize}")
//    public String selectPagesFromProduct(PageRequest pageRequest, Model model) {
//        commonModelOperation(model);
//        model.addAttribute("path", "/product/all/");
//
//        PageResult pageResult = productService.selectAllProductsPages(pageRequest);
//        List<ProductListItem> productList = (List<ProductListItem>) pageResult.getContent();
////        String productListJSONArray = JSONArray.fromObject(productList).toString();
////        model.addAttribute("productListJSONArray", productListJSONArray);
//        model.addAttribute("productList", productList);
//        model.addAttribute("pageNum", pageResult.getPageNum());
//        model.addAttribute("pageSize", pageResult.getPageSize());
//        model.addAttribute("totalPages", pageResult.getTotalPages());
//        model.addAttribute("totalSize", pageResult.getTotalSize());
//        return "product";
//    }

    /**
     * 异步 分页查询全部产品
     *
     * @param model
     * @return
     */
    @RequestMapping("/product/{typeName}/{typeValue}/{fragment}/{pageNum}/{pageSize}")
    public String selectPagesFromProductAjax(PageRequest pageRequest, Model model) {
        commonModelOperation(model);

        String typeName = pageRequest.getTypeName();
        String typeValue = pageRequest.getTypeValue();
        String fragment = pageRequest.getFragment();

        PageResult pageResult = null;
        switch (typeName) {
            case "all":
                pageResult = productService.selectAllProductsPages(pageRequest);
                break;
            case "class1":
                pageResult = productService.selectProductListByclass1(pageRequest, typeValue);
                break;
            case "class2":
                pageResult = productService.selectProductListByclass2(pageRequest, typeValue);
                break;
            default:
                break;
        }
        if (pageRequest == null) {
            return "error";
        }

        // 拼接用的路径前缀
        model.addAttribute("path", "/product/" + typeName + "/" + typeValue + "/");

        List<ProductListItem> productList = (List<ProductListItem>) pageResult.getContent();
        model.addAttribute("productList", productList);
        model.addAttribute("pageNum", pageResult.getPageNum());
        model.addAttribute("pageSize", pageResult.getPageSize());
        model.addAttribute("totalPages", pageResult.getTotalPages());
        model.addAttribute("totalSize", pageResult.getTotalSize());

        if (fragment.equals("0")) {
            return "product";
        } else {
            return "common::" + fragment;
        }
    }


    /**
     * 共同 Model 操作
     *
     * @param model
     */
    private void commonModelOperation(Model model) {
        model.addAttribute("pagename", "product");
    }
}
