package com.bilibili.demo02;

public class DemoWoman extends DemoMan{

    @Override
    public void sayHello(){
        System.out.println("(Woman) hi");
    }

    public void method(Greetable g){
        g.greet();
    }

    public void show(){
        /*method(()->{
            new DemoMan().sayHello();
        });*/

        method(super::sayHello);
        method(this::sayHello);
    }

    public static void main(String[] args) {

        new DemoWoman().show();
    }
}
