package com.bilibili.demo02;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DemoMain {
    public static void main(String[] args) throws Exception {

        Properties pps = new Properties();
        ClassLoader cld = DemoMain.class.getClassLoader();
        InputStream ras = cld.getResourceAsStream("DDS.properties");
        FileReader frr = new FileReader("D:\\LearningTasks\\IDEA Workspace\\Project003_Java\\Day-20210520\\src\\DDS.properties");
        pps.load(frr);

        String className = pps.getProperty("className");
        String methodName = pps.getProperty("methodName");

        Class cln = Class.forName(className);
        Object o = cln.getDeclaredConstructor().newInstance();
        Method mtd = cln.getMethod(methodName);
        mtd.invoke(o);
    }
}
