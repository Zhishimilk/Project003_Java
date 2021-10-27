package com.bilibili.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {
    public static void main(String[] args) {

        Connection cnt = null;
        Statement smt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into users value('zhangsan', '10086', 'null', '123456')";
            cnt = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql_001", "root", "root");
            smt = cnt.createStatement();
            int i = smt.executeUpdate(sql);
            if(i > 0){
                System.out.println(i);
            }else{
                System.out.println("lose");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(smt != null){
                try {
                    smt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(cnt != null){
                try {
                    cnt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
