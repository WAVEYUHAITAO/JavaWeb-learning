package com.hito.servlet;

import com.hito.pojo.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();

        //给session中存东西
        session.setAttribute("name",new Person("海涛",1));


        //获取session的id
        //每一种浏览器打开相同页面对应不同的sessionid
        String sessionID = session.getId();

        //判断session是不是新创建
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID:"+sessionID);
        }else {
            resp.getWriter().write("session已经在服务器中存在了, ID:"+sessionID);
        }

        //Session创建的时候做了什么事情
        //Cookie cookie = new Cookie("JSESSIONID",sessionID);
        //resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
