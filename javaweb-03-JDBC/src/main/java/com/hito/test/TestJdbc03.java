package com.hito.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc03 {
    @Test
    //junit单元测试
    //@Test注解只有在方法上有效，只要加了这个注解的方法，就可以直接运行
    public void test() throws SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        Connection connection = null;
        try {
            //1.加载驱动
            //Class.forName("com.mysql.cj.jdbc.Driver");

            //2.连接数据库
            connection = DriverManager.getConnection(url, username, password);

            //3.通知数据库开启事务
            connection.setAutoCommit(false);
            String sql1="update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql1).executeUpdate();

            //制造错误
            //int i = 1/0;
            String sql2="update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();
            connection.commit(); //以上两条SQL都成功就提交事务
            System.out.println("success");
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
