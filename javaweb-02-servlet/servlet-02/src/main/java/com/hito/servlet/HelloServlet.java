package com.hito.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Hello Servlet,I'm coming<h1>");

        //this.getInitParameter(); 初始化参数
        //this.getServletConfig(); servlet配置
        //this.getServletContext(); servlet上下文
        //web容器在启动的时候，它会为每个web程序都创建一个对应的servletcontext对象，它代表了当前的web应用
        //应用：1.共享数据 我在这个servlet中保存的数据可以再别的servlet使用
        //2.
        ServletContext servletContext = this.getServletContext();
        String username = "hito";
        servletContext.setAttribute("username",username); //将一个数据以键值对的形式保存在servletcontext中
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
