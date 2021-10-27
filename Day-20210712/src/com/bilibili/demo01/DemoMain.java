package com.bilibili.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoMain {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(1626081461876L);
        System.out.println(date1);
        System.out.println(date1.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fmt = sdf.format(date);
        System.out.println(fmt);
        try {
            Date d1 = sdf.parse(fmt);
            System.out.println(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
