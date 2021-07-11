package com.hito.servlet.user;

import com.hito.pojo.User;
import com.hito.service.user.UserService;
import com.hito.service.user.UserServiceImpl;
import com.hito.util.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet:控制层，调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--Start...");
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库中的密码进行对比，调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if(user!=null){//查有此人，可以登陆
            //将用户的信息放到Session中；
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部页面
            resp.sendRedirect("/jsp/frame.jsp");
        }else{//查无此人，无法登陆
            //转发回登陆页面,顺带历史它,用户名或者密码错误

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
