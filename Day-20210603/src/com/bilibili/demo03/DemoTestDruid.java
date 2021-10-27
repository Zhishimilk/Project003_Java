package com.bilibili.demo03;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class DemoTestDruid {
    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();
        ClassLoader cld = DemoTestDruid.class.getClassLoader();
        URL url = cld.getResource("druid.properties");
        String path = url.getPath();
        /*InputStream ras = cld.getResourceAsStream("druid.properties");*/
        try {
            pro.load(new FileReader(path));
            /*pro.load(ras);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        System.out.println(ds.getConnection());
    }
}
