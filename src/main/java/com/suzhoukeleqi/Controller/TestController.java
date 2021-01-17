package com.suzhoukeleqi.Controller;

import com.suzhoukeleqi.Service.IMailService;
import com.suzhoukeleqi.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class TestController {


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


    /**
     * 测试页面
     *
     * @return
     */
    @RequestMapping("/test")
    public String goToTest(HttpServletRequest request, ModelMap modelMap) {
        // 请求来源地址
        logger.debug(request.getHeader("REFERER"));

        modelMap.addAttribute("msg", "shit");
        return "test";
    }

    /**
     * 测试 thymeleaf 与 ajax 的异步更新
     *
     * @return
     */
    @RequestMapping("/testajax")
    public String goToTestAjax(ModelMap modelMap) {
        modelMap.addAttribute("msg", "ohhhhhhhhhhhhh");
        return "test::reflash";
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
