package com.bilibili.demo01;

public class DemoPrintable {

    public static void method(Printable p){

        p.print("hello world");
    }

    public static void main(String[] args) {

        method((s)->{
            System.out.println(s);
        });

        method(System.out::println);

        method(new PrintUppercase()::method1);
    }
}
