package com.bilibili.demo03;

public class DemoLambda {

    public static void showLog(int level, DemoMessage dmg){

        if(level == 1){
            System.out.println(dmg.method());
        }
    }

    public static void startThread(Runnable run){
        new Thread(run).start();
    }

    public static void main(String[] args) {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        String str1 = "Hello,";
        String str2 = "World!";

        showLog(1, ()->{
            return str1 + str2;
        });

        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        startThread(()->{
            System.out.println(Thread.currentThread().getName());
        });

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
