package com.bilibili.studentManagementDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args){
        long l = System.currentTimeMillis();
        //--------------------------------------
        /*
            1:用输出语句完成主界面的编写
            2:用Scanner实现键盘录入
            3:用switch语句完成操作的选择
            4:用循环完成再次回到主界面
         */

        ArrayList<Student> students = new ArrayList<>();

        while(true){
            System.out.println("-------欢迎来到学生管理系统-------");
            System.out.println("1.添加学生");
            System.out.println("2.修改学生");
            System.out.println("3.删除学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择:");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //
            switch (line) {
                case "1" -> {
                    System.out.println("添加学生");
                    addStudent(students);
                    break;
                }
                case "2" -> {
                    System.out.println("修改学生");
                    updateStudent(students);
                    break;
                }
                case "3" -> {
                    System.out.println("删除学生");
                    deleteStudent(students);
                    break;
                }
                case "4" -> {
                    System.out.println("查看所有学生");
                    findAllStudent(students);
                    break;
                }
                case "5" -> {
                    System.out.println("谢谢使用");
                    long l1 = System.currentTimeMillis();
                    System.out.println("本次程序共运行: " + (l1 - l) / 1000 + "s");
                    System.exit(0);
                }
                default -> System.out.println("你的输入有误!");
            }
        }
    }

    //添加学生信息
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        System.out.println("请输入学生学号:");
        String sid = sc.nextLine();

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getSid().equals(sid)){
                System.out.println("你输入的学号已存在!");
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("请输入学生姓名:");
            String name = sc.nextLine();
            System.out.println("请输入学生年龄:");
            String age = sc.nextLine();
            System.out.println("请输入学生居住的:");
            String address = sc.nextLine();

            Student student = new Student(sid, name, age, address);

            list.add(student);
            System.out.println("添加学生成功!");
        }
    }
    //查找所有学生信息
    public static void findAllStudent(ArrayList<Student> list){
        if(list.size() != 0){
            System.out.println("学号/姓名/年龄/居住地");
            for (Student s : list) {
                System.out.println(s.getSid() + "/" + s.getName() + "/" + s.getAge() + "/" + s.getAddress());
            }
        }else {
            System.out.println("暂无学生信息, 请添加后再查看!");
        }
    }
    //删除学生信息
    public static void deleteStudent(ArrayList<Student> list){
        boolean flag = true;
        System.out.println("请输入要删除的学生的学号:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if(list.size() != 0) {
            Iterator<Student> studentIterator = list.iterator();
            while (studentIterator.hasNext()) {
                if (studentIterator.next().getSid().equals(s)) {
                    studentIterator.remove();
                    System.out.println("删除学生成功!");
                    flag = false;
                }
            }
        }

        if(flag){
            System.out.println("你输入的学生号不存在!");
        }
    }
    //修改学生信息
    public static void updateStudent(ArrayList<Student> list){
        System.out.println("请输入要修改的学生的学号:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean flag = true;

       /* Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getSid().equals(s)){
                System.out.println();
            }
        }*/

        if(list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getSid().equals(s)){
                    System.out.println(list.get(i));
                    while (true){
                        System.out.println("1.修改学生姓名");
                        System.out.println("2.修改学生年龄");
                        System.out.println("3.修改学生住址");
                        System.out.println("4.保存退出");
                        System.out.println("请输入你要进行的操作:");
                        String s1 = sc.nextLine();
                        switch(s1) {
                            case "1" -> {
                                System.out.println("请输入学生的新姓名:");
                                String name = sc.nextLine();
                                list.get(i).setName(name);
                                break;
                            }
                            case "2" ->{
                                System.out.println("请输入学生新的年龄:");
                                String age = sc.nextLine();
                                list.get(i).setAge(age);
                                break;
                            }
                            case "3" ->{
                                System.out.println("请输入学生新的住址:");
                                String address = sc.nextLine();
                                list.get(i).setAddress(address);
                                break;
                            }
                            case "4" ->{
                                System.out.println("保存成功!");
                                flag = false;
                                return;
                            }
                            default -> {
                                System.out.println("你的输入有误!");
                            }
                        }
                    }
                }
            }
        }

        if(flag){
            System.out.println("你输入的学号不存在!");
        }
    }
}
