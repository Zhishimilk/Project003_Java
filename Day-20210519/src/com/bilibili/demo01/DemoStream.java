package com.bilibili.demo01;

import java.util.ArrayList;

public class DemoStream {

    // stream流
    // filter(); 加工
    // map(); 映射对象
    // count(); 统计
    // limit(); 截取
    // skip(); 跳过
    // concat(); 合流

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("张无忌");
        list.add("张日天");

        /*ArrayList<String> list1 = new ArrayList<>();
        for (String s: list) {

            if(s.startsWith("张")){
                list1.add(s);
            }
        }

        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list1) {

            if(s.length() == 3){
                list2.add(s);
            }
        }

        System.out.println(list2);*/

        list.stream().filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name->System.out.println(name));
    }
}
