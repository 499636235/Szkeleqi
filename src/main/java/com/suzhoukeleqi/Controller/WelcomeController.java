package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.IMailService;
import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class WelcomeController {


    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    /**
     * 注入发送邮件的接口
     * 代码参考: https://www.cnblogs.com/smfx1314/archive/2004/01/13/10332329.html
     */
    @Autowired
    private IMailService mailService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //把 "" 重定向到 "/index"
    @RequestMapping("")
    public String goToIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String goToIndex(ModelMap modelMap) {
        List<IndexProduct> indexProductList = productService.selectIndexProductList();
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        modelMap.addAttribute("indexProductList", indexProductListJSONArray);
//        logger.debug(indexProductListJSONArray);
        return "index";
    }

    @RequestMapping("/test")
    public String goToTest() {
        return "test";
    }

    @RequestMapping("/about")
    public String goToAbout() {
        return "about";
    }

    @RequestMapping("/product")
    public String goToProduct(ModelMap modelMap) {
        List<IndexProduct> indexProductList = productService.selectIndexProductList();
        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
        modelMap.addAttribute("indexProductList", indexProductListJSONArray);
        return "product";
    }

    @RequestMapping("/product/{id}")
    public String goToProductDetail(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "product_detail";
    }

    @RequestMapping("/news")
    public String goToNews() {
        return "news";
    }

    @RequestMapping("/case")
    public String goToCase() {
        return "case";
    }

    @RequestMapping("/contact")
    public String goToContact() {
        return "contact";
    }

    @RequestMapping("/search")
    public String goToSearch() {
        return "search";
    }


    /**
     * 代码参考: https://www.cnblogs.com/smfx1314/archive/2004/01/13/10332329.html
     */
    @RequestMapping("/testmail")
    public void sendmail() {
        mailService.sendSimpleMail("499636235@qq.com", "主题：你好普通邮件", "内容：第一封邮件");
    }

    @RequestMapping("/testhtmlmail")
    public void sendmailHtml() {
        mailService.sendHtmlMail("499636235@qq.com", "主题：你好html邮件", "<h1>内容：第一封html邮件</h1>");
    }

}
