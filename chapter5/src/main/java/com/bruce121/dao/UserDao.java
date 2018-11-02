package com.bruce121.dao;

import com.bruce121.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
@Service
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    /**
     * 使用原始jdbc操作
     *
     * @param userId
     * @return
     */
    public User getByOriginal(Long userId) {
        Connection conn = null;
        PreparedStatement preState = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得连接
            String url = "jdbc:mysql://localhost:3306/springboot-study";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            // 3.sql的承载对象
            String sql = String.format("select * from tbl_user where id = %d", userId);
            preState = conn.prepareStatement(sql);
            // 4.执行sql获得结果
            rs = preState.executeQuery();
            // 5.处理结果
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                user.setCreateTime(rs.getString("create_time"));
                user.setUpdateTime(rs.getString("update_time"));
            }

            return user;
        } catch (Exception e) {
            return new User();
        } finally {
            // 6.释放资源
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }

            try {
                if (preState != null) {
                    preState.close();
                }
            } catch (SQLException e) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return 用户
     */
    public User get(Long id) {
        List<User> userList = batchGet(id);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * 批量获取用户信息
     *
     * @param ids
     * @return 用户集合
     */
    public List<User> batchGet(Long... ids) {
        String sql = "SELECT * FROM tbl_user WHERE id IN (?)";
        return jdbcTemplate.query(sql, new Object[]{getIdStr(ids)}, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return the number of rows affected
     */
    public int save(User user) {
        String sql = "INSERT INTO tbl_user(id, name, age)  VALUES(?, ? ,?)";
        return jdbcTemplate.update(sql, new Object[]{user.getId(), user.getName(), user.getAge()}, new int[]{Types.BIGINT, Types.VARCHAR, Types.INTEGER});
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return the number of rows affected
     */
    public int update(User user) {
        String sql = "UPDATE tbl_user SET name=?, age=? WHERE id=?";
        return jdbcTemplate.update(sql, new Object[]{user.getName(), user.getAge(), user.getId()}, new int[]{Types.VARCHAR, Types.INTEGER, Types.BIGINT});
    }

    /**
     * 根据ids删除用户
     *
     * @param ids
     * @return the number of rows affected
     */
    public int delete(Long... ids) {
        String sql = "delete from tbl_user where id in (" + getIdStr(ids) + ")";
        return jdbcTemplate.update(sql);
    }

    private String getIdStr(Long[] ids) {
        StringBuffer idStr = new StringBuffer();
        for (Long id : ids) {
            idStr.append(id).append(",");
        }
        idStr.setLength(idStr.length() - 1);
        return idStr.toString();
    }

}
