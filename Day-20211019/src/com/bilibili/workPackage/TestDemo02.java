package com.bilibili.workPackage;

import java.util.Scanner;

public class TestDemo02 {
    public static void main(String[] args) {
        /*第九题：循环录入某学生的5门课程的成绩并计算平均分。如果某分数录入为负，则停止录入并提示录入错误。*/
        Scanner sc = new Scanner(System.in);
        int sumScore = 0;

        a : while(true){

            for(int i = 1; i <= 5 ; i++){

                System.out.println("请录入学生的第"+i+"门成绩:");
                int score = sc.nextInt();

                if(score < 0){
                    System.out.println("你的输入有误, 操作终止!");
                    break a;
                }else {
                    sumScore += score;
                }

                if(i == 5){
                    System.out.println("五门成绩的平均分为:" + sumScore / 5);
                }
            }
        }

        /*while(true){

            System.out.println("请录入学生的第一门成绩:");
            int score1 = sc.nextInt();
            System.out.println("请录入学生的第二门成绩:");
            int score2 = sc.nextInt();
            System.out.println("请录入学生的第三门成绩:");
            int score3 = sc.nextInt();
            System.out.println("请录入学生的第四门成绩:");
            int score4 = sc.nextInt();
            System.out.println("请录入学生的第五门成绩:");
            int score5 = sc.nextInt();

            if(score1<0 || score2<0 || score3<0 || score4<0){
                System.out.println("你录入的成绩有误请重新录入");
                break;
            }else {
                System.out.println("五门成绩的平均分为:" + (score1 + score2 + score3 + score4 + score5) / 5);
            }
        }*/
    }
}
