package com.hito.service.user;

import com.hito.pojo.Role;
import com.hito.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //用户登录
    public User login(String userCode,String password);
    //根据用户信息修改密码
    public boolean updatePwd(int id, String pwd);
    //查询记录数
    public int getUserCount(String username,int userRole);
    //根据条件查询用户列表
    public List<User> getUserList(String username, int userRole, int currentPageNo, int pageSize);

}
