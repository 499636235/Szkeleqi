package com.suzhoukeleqi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())

                //所有路径都被拦截
                .addPathPatterns("/admin/**")

                //添加不拦截路径
                .excludePathPatterns("/admin",
                        "/**/*.html",
                        "/**/*.js",
                        "/**/*.css"
                );
    }


}