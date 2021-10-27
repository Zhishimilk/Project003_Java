package com.bilibili.workPackage;

import java.util.Scanner;

public class TestDemo04 {
    public static void main(String[] args) {

        /*第十一题：
        假设一个简单的在ATM的取款过程如下：首先提示用户输入密码（password），
        最多只能输入3次，超过3次则提示用户"密码错误，请取卡"交易结束。
        如果用户密码正确，再提示用户输入金额（amount），ATM只能输出100元的纸币，一次取钱数要求最低0元，最高1000元。
        如果用户输入的金额符合上述要求，则打印输出用户取的钱数，最后提示用户"交易完成，请取卡"，否则提示用户重新输入金额。假设用户密码是"111111"。

        打印格式：

        第一种情况：三次密码输入错误
        请输入密码：2
        密码错误，请重新输入：3
        密码错误，请重新输入：4
        密码错误，请取卡

        第二种情况：密码输入正确，可以取款
        请输入密码：2
        密码错误，请重新输入：111111
        请输入取款金额：3000
        您输入的取款金额有误，请重新输入：999
        请取走现金：999元
        交易完成，请取卡
        */


        Scanner sc = new Scanner(System.in);
        int password = 111111;

        a : for (int i = 0; i < 3; i++) {

            System.out.println("请输入密码:");
            if(sc.nextInt() == password){
                while(true){

                    System.out.println("请输入取款金额:");
                    int money = sc.nextInt();
                    if(money % 100 !=0 || money < 0 || money > 1000){
                        System.out.println("你输入的金额有误, 请重新输入:");
                    }else{
                        System.out.println("请取走现金:" + money + "元");
                        System.out.println("交易完成请取卡!");
                        break a;
                    }
                }
            }else{
                if(i == 2){
                    System.out.println("密码错误, 请取卡");
                    break;
                }
                System.out.println("你的密码输入错误，请再次尝试!");
            }
        }
    }
}
