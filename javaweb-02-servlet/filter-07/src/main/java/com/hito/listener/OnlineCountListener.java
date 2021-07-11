package com.hito.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//同级网站在线人数：统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听
    //一旦创建session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        //这里设置session的过期时间，以秒为单位，实际session结束时间长于5秒，大概1分钟
        //se.getSession().setMaxInactiveInterval(5);
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount= 1;
        }else {
            //int count = onlineCount;
            onlineCount= onlineCount + 1;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
        System.out.println("session被创建啦");
    }
    //销毁session监听
    /*
    session销毁的两种方法：
    1.手动销毁 session.invalidate();
    2.在web.xml中设置session timeout
     */

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount= 1;
        }else {
            //int count = onlineCount;
            onlineCount= onlineCount - 1;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
        System.out.println("session被销毁了");
    }
}
