package com.bupt.crud.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Myservlet extends HttpServlet {

    //处理get请求
    private void doTx2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add new method");

    }
    //处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("tx");
        doPost(req,resp);
        System.out.println("master");

    }

    //处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("hello myServlet");
        System.out.println("lc add one line modify by lc new line 4.22updateByLc afternoonupdateByTx2");

    }


    public void newM(){
        System.out.println("master newMethod added by tx2");
    }

    public void newTx2(){
        System.out.println("tx2 add one method");
    }

}
