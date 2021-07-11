package com.hito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.hito.util.Constant.USER_SESSION;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        String username = req.getParameter("username");
        if(username.equals("admin")){
            //登陆成功
            req.getSession().setAttribute(USER_SESSION,req.getSession().getId());
            resp.sendRedirect("/f7/sys/success.jsp");
        }else {
            //登陆失败
            resp.sendRedirect("/f7/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
