package com.bilibili.demo03;

@SuppressWarnings("all")
public class DemoAnnotation {

    // 默认注解:
    // @Override: 检测该注解标注的方法是否继承(实现)自父类(接口)
    // @Deprecated: 标注已过时的内容
    // @SuppressWarnings: 压制警告
    // 元注解:
    // @Target: 描述注解作用域
    //     value:
    //         ①TYPE: 作用于类上
    //         ②METHOD: 作用于方法上
    //         ③FIELD: 作用于成员变量上
    // @retention: 描述注解被保留阶段
    //     value:
    //         ①SOURCE: 当前注释的注解被编译器识别
    //         ②CLASS: 当前注释的注解保留到class字节码文件中
    //         ③RUNTIME: 当前注释的注解保留到class字节码文件中,并被JVM读取到
    // @Documented: 描述注解是否被抽取到Api文档中
    // @Inherited: 描述注解是否被子类继承

    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public static void method1(){
        System.out.println("Obsolete");
    }

    public static void method2(){
        System.out.println("Now");
    }

}
