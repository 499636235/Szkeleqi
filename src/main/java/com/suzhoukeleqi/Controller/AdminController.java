package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/admin")
    public String goToAdmin() {
        return "admin";
    }

    @RequestMapping("/admin/login")
    public String adminLogin(String username, String password, ModelMap modelMap) {
        Integer num = userService.selectUserByUsername(username);


        if (num == null) {
            modelMap.addAttribute("USERNAME_MSG","USERNAME_DENIED");
            return "/admin";
        }

        num = userService.userLogin(username, password);

        if (num == null) {
            modelMap.addAttribute("PASSWORD_MSG","PASSWORD_DENIED");
            return "/admin";
        }
        return "redirect:/index";
    }

}
