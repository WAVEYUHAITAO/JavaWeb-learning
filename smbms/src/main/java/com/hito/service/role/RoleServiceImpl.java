package com.hito.service.role;

import com.hito.dao.BaseDao;
import com.hito.dao.role.RoleDao;
import com.hito.dao.role.RoleDaoImpl;
import com.hito.pojo.Role;
import com.hito.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;
    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }
        return  roleList;
    }
    @Test
    public void test3(){
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        System.out.println(roleList);
        for (Role role : roleList){
            System.out.println(role.getRoleName());
        }
    }
}
