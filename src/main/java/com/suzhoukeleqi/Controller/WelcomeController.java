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
public class WelcomeController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping("/index")
    public String goToIndex(String s){
        return "index";
    }

    @RequestMapping("/index/haha")
    public String goToIndex1(String s){
        return "index";
    }

    @RequestMapping("/test")
    public String goToTest(String s){
        return "test";
    }

    @RequestMapping("/about")
    public String goToAbout(String s){
        return "about";
    }

    @RequestMapping("/product")
    public String goToProduct(String s){
        return "product";
    }

    @RequestMapping("/news")
    public String goToNews(String s){
        return "news";
    }

    @RequestMapping("/case")
    public String goToCase(String s){
        return "case";
    }

    @RequestMapping("/contact")
    public String goToContact(String s){
        return "contact";
    }

    @RequestMapping("/search")
    public String goToSearch(String s){
        return "search";
    }

    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String GetUser(@PathVariable int id){
        User user = userService.selectUser(id);
        return user.toString();
    }
}
