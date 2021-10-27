package com.bilibili.demo03;

import java.util.Arrays;
import java.util.Comparator;

public class DemoMain {

    public static Comparator<String> cpb(){

        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };*/

        return (o1, o2)->{
            return o1.length() - o2.length();
        };
    }

    public static void main(String[] args) {

        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        String[] arr = {"bbb", "d", "aaaa", "cc"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, cpb());
        System.out.println(Arrays.toString(arr));

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
