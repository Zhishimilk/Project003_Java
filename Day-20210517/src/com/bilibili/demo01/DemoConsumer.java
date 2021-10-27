package com.bilibili.demo01;

import java.util.function.Consumer;

public class DemoConsumer {

    public static void method(String name, Consumer<String> csm){
        csm.accept(name);
    }

    public static void main(String[] args) {

        method("张三", (String name)->{
            System.out.println(name);
            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
