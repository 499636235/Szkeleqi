package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.Service.UserService;
import com.suzhoukeleqi.entity.Product;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * admin登录页面
     *
     * @return
     */
    @RequestMapping("/admin")
    public String goToAdmin() {
        return "admin";
    }

    /**
     * admin登录 的业务处理
     *
     * @param username
     * @param password
     * @param modelMap
     * @return
     */
    @RequestMapping("/admin/login")
    public String adminLogin(String username, String password, ModelMap modelMap) {
        Integer num = userService.selectUserByUsername(username);


        if (num == null) {
            modelMap.addAttribute("USERNAME_MSG", "USERNAME_DENIED");
            return "/admin";
        }

        num = userService.userLogin(username, password);

        if (num == null) {
            modelMap.addAttribute("PASSWORD_MSG", "PASSWORD_DENIED");
            return "/admin";
        }
        return "redirect:/admin/admin_index";
    }

    /**
     * admin登录后的页面
     *
     * @return
     */
    @RequestMapping("/admin/admin_index")
    public String goToAdminIndex() {
        return "admin_index";
    }

    /**
     * 根据第一种大类查询产品
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/admin/admin_index/product")
    public String selectAllFromProduct(ModelMap modelMap) {
        List<Product> productList = productService.selectAllFromProduct();
        String productListJSONArray = JSONArray.fromObject(productList).toString();
        modelMap.addAttribute("productList", productListJSONArray);
        return "admin_index";
    }


}
