package com.hito.service.user;

import com.hito.dao.BaseDao;
import com.hito.dao.user.UserDao;
import com.hito.dao.user.UserDaoImpl;
import com.hito.pojo.User;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;

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
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "145123456");
        System.out.println(admin.getUserPassword());
    }
}
