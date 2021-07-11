package com.hito.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("WEB-INF/classes/缺氧.png");
        System.out.println("下载文件路径："+realPath);
        //2.下载的文件名是啥？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //3.设置想办法让浏览器能够支持下载我们需要的东西,设置响应头，注意attachment后面是分号，如果是中文的文件名注意要转码为utf-8,否则下载后的文件名是__.png
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        //4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6.获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将fileoutputstream写入缓冲区
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        //8.关闭流
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
