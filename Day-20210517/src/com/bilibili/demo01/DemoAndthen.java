package com.bilibili.demo01;

import java.util.function.Consumer;

public class DemoAndthen {

    public static void method(String s, Consumer<String> con1, Consumer<String> con2){

        con1.andThen(con2).accept(s);
    }

    public static void method2(String[] arr, Consumer<String> con1, Consumer<String> con2){
        for (int i = 0; i < arr.length; i++) {
            con1.andThen(con2).accept(arr[i]);
        }
    }

    public static void main(String[] args) {

        long l0 = System.currentTimeMillis();
        //-----------------------------------

        /*method("zhangsan", (String s)->{
            System.out.println(s);
        }, (String s)->{
            String s1 = new StringBuilder(s).reverse().toString();
            System.out.println(s1);
        });*/

        String[] arr = {"张三,女", "李四,女", "王五,男"};
        method2(arr, (String s)->{
            String s1 = s.split(",")[0];
            System.out.print("#name: "+s1);
        }, (String s)->{
            String s2 = s.split(",")[1];
            System.out.println(" #sex: "+s2);
        });

        //-----------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
