package com.bilibili.demo01;

public class DemoPerson {
    public String name;
    protected String sex;
    String interest;
    private int age;

    public DemoPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public DemoPerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DemoPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
