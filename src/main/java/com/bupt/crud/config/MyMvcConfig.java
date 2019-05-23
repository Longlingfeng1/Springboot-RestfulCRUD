package com.bupt.crud.config;


import com.bupt.crud.component.LoginHandlerInterceptor;
import com.bupt.crud.component.MyLocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/demo1").setViewName("success");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //super.addInterceptors(registry);
//                //静态资源；  *.css , *.js
//                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("**")
//                        .excludePathPatterns("/index.html","/","/user/login")
//                        .excludePathPatterns("/static/**");
//            }
        };
        return adapter;
    }



//    //注册拦截器
////    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        //静态资源，*.css,Springboot已经做好了静态资源映射，无需再加上静态资源
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html")
//                .excludePathPatterns("/static/**")
//                .excludePathPatterns("/")
//                .excludePathPatterns("/user/login");
//    }
//
//    @Override
//    //需要告知系统，这是要被当成静态文件的！
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 设置文件上传的文件不拦截
////        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
//        //第一个方法设置访问路径前缀，第二个方法设置资源路径
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/demo1").setViewName("success");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/main.html").setViewName("dashboard");
//    }
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////    }
//
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}

