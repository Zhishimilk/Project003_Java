package com.bilibili.demo01;

import java.util.function.Function;

public class DemoFunction {

    public static void method1(String s, Function<String, Integer> fct, Function< Integer, String> fct2){
        String dd = fct.andThen(fct2).apply(s);
        System.out.println(dd);
    }

    public static void main(String[] args) {

        method1("1234", (String s)->{
            return Integer.parseInt(s)+10;
        }, (Integer i)->{
            return i.toString();
        });
        
    }
}
