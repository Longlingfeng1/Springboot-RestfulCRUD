package com.bupt.crud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("contextInitialized..web启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextDestroyed...web销毁");
    }
}
