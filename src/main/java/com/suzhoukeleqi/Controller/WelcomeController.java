package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class WelcomeController {

//    @Autowired
//    @Qualifier("userServiceImpl")
//    UserService userService;

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    //重定向到  /index
    @RequestMapping("")
    public String goToIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String goToIndex(ModelMap modelMap) {
        StringBuilder stringBuilder = new StringBuilder();
        List<IndexProduct> indexProductList = productService.selectIndexProductList();
//        List<IndexProduct> indexProductList = new ArrayList<>();
//        indexProductList.add(productService.selectIndexProductList().get(0));
//        for (IndexProduct indexProduct : indexProductList) {
//            stringBuilder.append(
//                    "<li data-plugin=\"appear\" data-animate=\"slide-bottom\" class=\"animation-slide-bottom\">\n" +
//                    "   <a href=\"/product/" + indexProduct.getProduct_id() + "\">\n" +
//                    "       <p>\n" +
//                    "           <img src=\"" + indexProduct.getPicture() + "\" alt=\""+ indexProduct.getName() + "\" style=\"display: inline;\">\n" +
//                    "       </p>\n" +
//                    "       <span>" + indexProduct.getName() + "</span>\n" +
//                    "   </a>\n" +
//                    "</li>");
//        }
        modelMap.addAttribute("indexProductList", JSONArray.fromObject(indexProductList).toString());
//        modelMap.addAttribute("indexProductList", stringBuilder.toString());
        return "index";
    }

    @RequestMapping("/test")
    public String goToTest(String s) {
        return "test";
    }

    @RequestMapping("/about")
    public String goToAbout(String s) {
        return "about";
    }

    @RequestMapping("/product")
    public String goToProduct(String s) {
        return "product";
    }

    @RequestMapping("/product/{id}")
    public String goToProductDetail(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "product_detail";
    }

    @RequestMapping("/news")
    public String goToNews(String s) {
        return "news";
    }

    @RequestMapping("/case")
    public String goToCase(String s) {
        return "case";
    }

    @RequestMapping("/contact")
    public String goToContact(String s) {
        return "contact";
    }

    @RequestMapping("/search")
    public String goToSearch(String s) {
        return "search";
    }

//    @RequestMapping("getUser/{id}")
//    @ResponseBody
//    public String GetUser(@PathVariable int id) {
//        User user = userService.selectUser(id);
//        return user.toString();
//    }
}
