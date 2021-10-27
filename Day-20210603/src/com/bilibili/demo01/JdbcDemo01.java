package com.bilibili.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_001", "root", "root");
        String sql = "update users set Phone = ? where Name = 1";
        PreparedStatement pst = cnt.prepareStatement(sql);
        pst.setString(1, "10010");
        /*Statement stm = cnt.createStatement();*/
        int i = pst.executeUpdate();
        System.out.println(i);
        pst.close();
        cnt.close();
    }
}
