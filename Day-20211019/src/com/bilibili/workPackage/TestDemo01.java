package com.bilibili.workPackage;

import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args) {
        /*第八题：请按如下要求编写程序,打印菜单:
        1.从键盘上录入一个1到5的数字;
        2.当数字为1时打印菜单"新建";
        当数字为2时打印菜单"打开文件";
        当数字为3时打印菜单"保存";
        当数字为4时打印菜单"刷新";
        当数字为5时打印菜单"退出",并退出程序;*/

        Scanner sc = new Scanner(System.in);

        a : while (true){
            System.out.println("1.新建     2.打开文件     3.保存     4.刷新     5.退出");
            System.out.println("请输入你的选择:");
            switch (sc.nextLine()){
                case "1" ->{
                    System.out.println("新建");
                    break;
                }
                case "2" ->{
                    System.out.println("打开文件");
                    break;
                }
                case "3" ->{
                    System.out.println("保存");
                    break;
                }
                case "4" ->{
                    System.out.println("刷新");
                    break;
                }
                case "5" ->{
                    System.out.println("退出");
                    System.out.println("谢谢使用!");
                    break a;
                }
                default -> System.out.println("你的选择有误!");
            }
        }
    }
}
