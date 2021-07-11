package com.hito.test;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";

        //1.加载驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.创建向数据库发送statement的对象 :CRUD
        Statement statement = connection.createStatement();
        //4.编写SQL
        String sql="select * from users";
        //5.执行SQL,返回结果集
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()){
            System.out.print("id="+rs.getObject("id")+"\t");
            System.out.print("name="+rs.getObject("name")+"\t");
            System.out.print("password="+rs.getObject("password")+"\t\t");
            System.out.print("email="+rs.getObject("email")+"\t\t");
            System.out.println("birthday="+rs.getObject("birthday"));
        }

        //6.关闭连接，释放资源，一定要先开后关
        rs.close();
        statement.close();
        connection.close();
    }


}
