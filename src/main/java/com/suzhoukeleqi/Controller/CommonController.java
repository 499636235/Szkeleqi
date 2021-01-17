package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.entity.IndexProduct;
import com.suzhoukeleqi.entity.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class CommonController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 导航栏可以抵达的页面 {测试，主页，关于，产品，新闻，案例，联系，搜索}
    String[] pageArray = {"test", "index", "about", "product", "news", "case", "contact", "search"};
    List<String> pageList = new ArrayList<String>(Arrays.asList(pageArray));

    /**
     * 通用页面
     * 只是为了防止 common.html 报红，实际上是重定向到 index
     *
     * @return
     */
    @RequestMapping("/common")
    public String goToCommon(Model model, PageRequest pageRequest) {
        if (true) {
            return "redirect:/nav/index";
        }
        model.addAttribute("path", "");
        model.addAttribute("pagename", "");
        model.addAttribute("pageNum", "");
        model.addAttribute("pageSize", "");
        model.addAttribute("totalPages", "");
        model.addAttribute("totalSize", "");
        model.addAttribute("indexProductList", new ArrayList<IndexProduct>());
        return "common";
    }


    /**
     * 把 "" 重定向到 "/nav/index"
     *
     * @return
     */
    @RequestMapping("")
    public String nullToIndex() {
        return "redirect:/nav/index";
    }


    /**
     * 从导航栏跳转到相应的页面
     *
     * @return
     */
    @RequestMapping("/nav/{pagename}")
    public String toPagename(@PathVariable String pagename, Model model) {
        model.addAttribute("pagename", pagename);
        if (pageList.contains(pagename)) {
            pageService(model);
            return pagename;
        } else {
            return "error";
        }
    }

    /**
     * 根据页面名处理相应的业务，修改 model
     *
     * @param model
     */
    private void pageService(Model model) {
        // 如果是首页
        if (model.getAttribute("pagename").equals("index")) {
            // 首页参数
            List<IndexProduct> indexProductList = productService.selectIndexProductList();
            model.addAttribute("indexProductList", indexProductList);
//        String indexProductListJSONArray = JSONArray.fromObject(indexProductList).toString();
//        model.addAttribute("indexProductList", indexProductListJSONArray);
//        logger.debug(indexProductListJSONArray);
        }

        return;
    }

    /**
     * 产品页面
     * 重定向到 全部产品
     *
     * @param model
     * @return
     */
    @RequestMapping("/product")
    public String goToProduct(Model model) {
        return "redirect:/product/all/1/8";
    }

}
