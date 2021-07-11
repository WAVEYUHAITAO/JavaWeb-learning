package com.hito.test;

import java.sql.*;

public class TestJdbc02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        //1.加载驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4.编写SQL
        String sql = "INSERT INTO users(id,`name`,`password`,`email`,birthday) VALUES (?,?,?,?,?);";

        //3.预编译
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 4);//给第一个占位符问号的值赋值为1
        statement.setString(2, "hito");
        statement.setString(3, "123456");
        statement.setString(4, "hito@qq.com");
        statement.setDate(5, new Date(new java.util.Date().getTime()));

        //5.执行SQL,返回结果集
        //返回的i是受影响的行数

        int i = statement.executeUpdate();
        System.out.println("影响的行数="+i);
        if (i > 0) {
            System.out.println("插入成功");
        }


        //6.关闭连接，释放资源，一定要先开后关
        statement.close();
        connection.close();
    }
}
