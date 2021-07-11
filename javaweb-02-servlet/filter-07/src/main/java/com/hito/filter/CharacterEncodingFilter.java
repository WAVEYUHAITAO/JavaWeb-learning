package com.hito.filter;

import jakarta.servlet.*;

import java.io.IOException;
//导包不要错，我们用的tomcat10.所以用jakarta包，10以下javax包
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("characterEncodingFilter初始化完成");
    }

    //chain 链
    /*
    1.过滤中的所有代码，在过滤特定请求的时候都会执行
    2.必须要让过滤器继续通行
        chain.dofilter(request,response)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("characterEncodingFilter执行前...");
        chain.doFilter(request,response);//让我们的请求继续走，如果不写，程序到这里就被拦截停止！
        System.out.println("characterEncodingFilter执行后...");
    }

    @Override
    public void destroy() {
        System.out.println("characterEncodingFilter销毁");
    }
}
