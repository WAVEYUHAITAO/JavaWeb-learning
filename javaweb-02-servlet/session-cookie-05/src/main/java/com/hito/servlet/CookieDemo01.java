package com.hito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你，你来的时间，把这个时间封装称谓一个信件，你下次带来，我就知道你来了
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("GBK");
        PrintWriter out = resp.getWriter();

        //cookie,服务器端从客户端获取cookie
        Cookie[] cookies = req.getCookies();//这里返回数组，说明cookie可能存在多个
        System.out.println(cookies.length);
        //判断cookie是否存在
        //因为我用的edge访问网站自动生成一个jsessionid的cookie所以大于1再执行我们的代码,小于等于1就是第一次访问本站
        if(cookies.length>1){
            //如果存在怎么办
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取客户端当前网站下所有的cookie名字和值
                System.out.println(cookie.getName()+":"+cookie.getValue());
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                        //获取cookie的值
                        //这里是将millseconds转化为日期
                        long lastLoginTime = Long.parseLong(cookie.getValue());
                        Date date = new Date(lastLoginTime);
                        out.write(date.toLocaleString());
                }

            }
        }else {
            out.write("这是您第一次访问本站");
        }

        //服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        //设置cookie有效期为1天,这里可以设置cookie的过期时间,普通没设置是关闭浏览器，绘话结束即过期
        //一个cookie只能保存一个信息
        //一个web站点可以给浏览器发送多个cookie，最多存放20个cookie
        //cookie大小有限制4kb
        //300个cookie浏览器上限

        //删除cookie
        //不设置有效期，关闭浏览器，自动失效
        //设置有效期为0
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
