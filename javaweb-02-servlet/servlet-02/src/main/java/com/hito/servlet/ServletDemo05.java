package com.hito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过servletcontext访问一些properties ,web 项目从/WEB-INF/classes/开始写
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/resources/db.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("username");
        String pwd = properties.getProperty("password");
        resp.getWriter().println(user);
        resp.getWriter().println(pwd);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
