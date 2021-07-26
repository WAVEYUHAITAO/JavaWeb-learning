package com.hito.dao.role;

import com.hito.dao.BaseDao;
import com.hito.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    //获取角色列表
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList<>();
        if(connection!=null){
            String sql = "select * from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleCode(rs.getString("roleCode"));
                role.setRoleName(rs.getString("roleName"));
                role.setCreatedBy(rs.getInt("createdBy"));
                role.setCreationDate(rs.getDate("creationDate"));
                role.setModifyBy(rs.getInt("modifyBy"));
                role.setModifyDate(rs.getDate("modifyDate"));
                roleList.add(role);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return roleList;
    }
}
