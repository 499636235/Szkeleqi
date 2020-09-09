package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.UserService;
import com.suzhoukeleqi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping("product/product_detail/{id}")
    @ResponseBody
    public String GetProductDetail(@PathVariable int id){
        User user = userService.selectUser(id);
        return user.toString();
    }
}
