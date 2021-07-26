package com.hito.servlet;

import com.hito.pojo.User;
import com.hito.utils.Sendmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户请求，封装成对象
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, password, email);
        //用户注册成功后，给用户发送一封邮件
        //我们使用线程来专门发送邮件，防止出现耗时，和网站注册人数过多的情况
        Sendmail sendmail = new Sendmail(user);
        //启动线程，线程启动之后就会执行run方法来发送邮件
        sendmail.start();

        //注册用户
        req.setAttribute("message", "注册成功，我们已经发了一封带有注册信息的电子邮件，请及时查收");
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
