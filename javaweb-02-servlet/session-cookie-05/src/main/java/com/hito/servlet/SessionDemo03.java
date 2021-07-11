package com.hito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;

public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        //session使用场景
        //保存一个登陆用户的信息
        //购物车信息
        //在整个网站中经常会使用的数据，我们将它保存在session中
        HttpSession session = req.getSession();
       //移除session存放的对应名字
        session.removeAttribute("name");
        //注销session，会立马生成一个新的
        session.invalidate();
        resp.getWriter().write("您的session已注销");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
