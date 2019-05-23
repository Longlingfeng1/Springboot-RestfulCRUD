package com.bupt.crud.config;

import com.bupt.crud.filter.MyFilter;
import com.bupt.crud.listener.MyListener;
import com.bupt.crud.servlet.Myservlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;


//配置和Servlet相关的 比如三大组件（servlet、Filter、Listener） 和 定制嵌入式Servlet


@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet(),"/myServlet");
        return  servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){

        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8091);
            }
        };
    }
}
