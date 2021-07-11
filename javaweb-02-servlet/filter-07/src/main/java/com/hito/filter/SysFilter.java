package com.hito.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.hito.util.Constant.USER_SESSION;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //原来的servletrequest不可以得到session，所以就强转成Httpservlet
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        request = (HttpServletRequest)servletRequest;
        response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute(USER_SESSION)==null){
            response.sendRedirect("/f7/error.jsp");
        }

        filterChain.doFilter(request,response);
    }
}
