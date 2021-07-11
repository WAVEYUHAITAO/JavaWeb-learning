package com.hito.dao.user;

import com.hito.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    //得到要登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
