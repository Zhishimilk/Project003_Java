package com.bilibili.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String info;
    private static String password;
    private static String driver;

    static {
        try {
            ClassLoader cld = JDBCUtils.class.getClassLoader();
            InputStream ras = cld.getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(ras);
            url = pro.getProperty("url");
            info = pro.getProperty("info");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, info, password);
    }

    public static  void close(Connection cnt, Statement stm, ResultSet rst){

        if(rst != null){
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stm != null){
            try {
                stm.close();
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
    public static  void close(Connection cnt, Statement stm){

        close(cnt, stm, null);
    }
    public static  void close(Connection cnt){

        close(cnt, null, null);
    }
}
