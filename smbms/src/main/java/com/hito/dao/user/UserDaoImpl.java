package com.hito.dao.user;

import com.hito.dao.BaseDao;
import com.hito.pojo.Role;
import com.hito.pojo.User;
import com.mysql.cj.util.StringUtils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from smbms_user where (userCode,userPassword)=(?,?)";
            Object[] params = {userCode,userPassword};

            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);

        }
        return user;
    }

    @Override
    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        System.out.println("UserServlet:"+password);
        PreparedStatement pstm = null;
        int execute = 0;
        if(connection!=null){
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object params[]={password,id};
            execute=BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null,pstm,null);
        }
        return execute;
    }

    //根据用户名或者角色查询用户总数
    @Override
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;


        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<>();//存放我们的参数

            if(!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.userName like ?");
                list.add("%"+username+"%");//index:0
            }

            if(userRole>0){
                sql.append(" and u.userRole like ?");
                list.add(userRole);//index:1
            }

            //怎么把list转换为数组
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl->getUserCount:"+ sql.toString());//输出最后完整的sql语句

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            if(rs.next()){
                count = rs.getInt("count");//从结果集中获取最终的数量
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection connection, String username, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u, smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<>();
            if(!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.userName like ?");
                list.add("%"+username+"%");
            }
            if(userRole>0){
                sql.append(" and u.userRole like ?");
                list.add(userRole);
            }
            //分页这里是什么意思
            //1  01234   (1-1)*5 第一页从0开始
            //2  56789   (2-1)*5 第二页从5开始
            //3  10~14   (3-1)*5 第三页从10开始
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo=(currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("UserDaoImpl->getUserList:"+sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                userList.add(user);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return userList;
    }

}

