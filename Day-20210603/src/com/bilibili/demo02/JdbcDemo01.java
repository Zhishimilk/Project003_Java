package com.bilibili.demo02;

import com.bilibili.util.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo01 {

    public static void main(String[] args) {

        List<User> list = new JdbcDemo01().method();
        System.out.println(list);
    }

    public List<User> method(){

        Connection cnt = null;
        Statement smt = null;
        ResultSet rst = null;
        List<User> list = new ArrayList<>();
        try {
            cnt = JDBCUtils.getConnection();
            cnt.setAutoCommit(false);
            String sql = "SELECT * FROM users";
            smt = cnt.createStatement();
            rst = smt.executeQuery(sql);
            while (rst.next()){
                list.add(new User(rst.getString("Name"), rst.getString("Phone"), rst.getString("Email"), rst.getString("Password")));
            }
            cnt.commit();
        } catch (SQLException e) {
            if(cnt != null){
                cnt.rollback();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(cnt, smt, rst);
            return list;
        }
    }
}
