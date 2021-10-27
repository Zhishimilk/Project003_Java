package com.bilibili.demo03;

import com.bilibili.util.DruidUtil;
import com.bilibili.util.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DemoTestC3p0 {
    public static void main(String[] args) {
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource("testC3p0");
            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection cnt = null;
        try {
            cnt = DruidUtil.getConnection();
            System.out.println(cnt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DataSource ds = DruidUtil.getPools();
        Connection cnt1 = null;
        try {
            cnt1 = ds.getConnection();
            System.out.println(cnt1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(cnt);
            JDBCUtils.close(cnt1);
        }
    }
}
