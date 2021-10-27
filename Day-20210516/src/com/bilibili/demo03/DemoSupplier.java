package com.bilibili.demo03;

import java.util.function.Supplier;

public class DemoSupplier {

    public static String getString(Supplier<String> sup){

        return sup.get();
    }

    public static int getMax(Supplier<Integer> sup){

        return sup.get();
    }

    public static void main(String[] args) {


        long l0 = System.currentTimeMillis();
        //--------------------------------------------------

        String str = getString(() -> {
            return "胡歌";
        });
        System.out.println(str);

        int[] arr = {1, 7, 9, 3, 781};
        int max = getMax(() -> {
            int Max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > Max) {
                    Max = arr[i];
                }
            }
            return Max;
        });
        System.out.println(max);

        //--------------------------------------------------
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l0+"mms");
    }
}
