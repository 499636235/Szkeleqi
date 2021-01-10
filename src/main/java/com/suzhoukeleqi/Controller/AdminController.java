package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    @ResponseBody
    public String adminLogin(String username, String password) {
        Integer num = userService.selectUserByUsername(username);
        String result = null;

        if (num == null) {
            result = "USERNAME_DENIED";
            return result;
        }

        num = userService.userLogin(username, password);

        if (num == null) {
            result = "PASSWORD_DENIED";
        }
        return result;
    }

}
