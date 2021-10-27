package com.bilibili.demo01;

import java.util.function.Predicate;

public class DemoPredicate {

    //本期主题
    // predicate<T> test(T t);
    // and(), or(), negate();
    //

    public static boolean method(String s, Predicate<String> pdt, Predicate<String> pdt2){

        /*return pdt.test(s) && pdt2.test(s);*/
        return pdt.and(pdt2).test(s);
    }

    public static void main(String[] args) {

        long l0 = System.currentTimeMillis();
        //-----------------------------------

        String s = "abcdef";
        boolean a = method(s, (String str) -> {
            return str.length() > 5;
        }, (String str) -> {
            return str.contains("a");
        });
        System.out.println(a);

        //-----------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
