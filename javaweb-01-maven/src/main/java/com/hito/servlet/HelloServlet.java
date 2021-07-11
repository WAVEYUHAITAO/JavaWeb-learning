package com.hito.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Serverlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Serverlet!</h1>");
        out.println("<h1>你好，你好</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
