package com.hito.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc01 {
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
        String sql1="delete from users where id = 4";

        //5.执行SQL,返回结果集,返回的i是受影响的行数
        int i = statement.executeUpdate(sql1);
        if(i>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //6.关闭连接，释放资源，一定要先开后关
        statement.close();
        connection.close();
    }
}
