package com.bilibili.workPackage;

import java.util.Random;
import java.util.Scanner;

public class TestDemo03 {
    public static void main(String[] args) {
        /*第十题：
        某商场实行新的抽奖规则：如果会员号的百位数字等于产生的随机数字，则该会员为幸运会员，且实现以下要求：
        从键盘上接收会员号,使用if-else选择结构实现幸运抽奖*/
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (true){

            System.out.println("请输入你的会员号:");
            int vip = sc.nextInt();
            int num = rd.nextInt(10);
            System.out.println("本期幸运号码为:" + num);
            if(vip / 100 % 10 == num){
                System.out.println("恭喜了, 中奖了!");
                break;
            }else{
                System.out.println("很遗憾, 你没有中奖.");
            }
        }
    }
}
