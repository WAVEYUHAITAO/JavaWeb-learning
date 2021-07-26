package com.hito.service.user;

import com.hito.dao.BaseDao;
import com.hito.dao.user.UserDao;
import com.hito.dao.user.UserDaoImpl;
import com.hito.pojo.Role;
import com.hito.pojo.User;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    //业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用具体的数据库操作
            user = userDao.getLoginUser(connection, userCode,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        System.out.println("UserService:"+pwd);
        Connection connection = null;
        boolean flag =false;
        //修改密码
        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection,id,pwd)>0){
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    //查询记录数
    @Override
    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int userCount = 0;
        try {
            connection = BaseDao.getConnection();
            userCount = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return  userCount;
    }

    @Override
    public List<User> getUserList(String username, int userRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName--->"+username);
        System.out.println("queryUserRole--->"+userRole);
        System.out.println("currentPageNo--->"+currentPageNo);
        System.out.println("pageSize--->"+pageSize);

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection,username,userRole,currentPageNo,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }



    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "123456");
        System.out.println(admin.getUserPassword());
        System.out.println(admin);
    }
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null, 1);
        System.out.println(userCount);
    }
    @Test
    public void test2(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.getUserList("刘", 2, 1, 5);
        System.out.println(userList);
    }

}
