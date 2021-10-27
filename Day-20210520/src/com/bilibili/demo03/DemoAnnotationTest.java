package com.bilibili.demo03;

import org.junit.Test;

import java.lang.reflect.Method;

@MyAnnotation(className = "com.bilibili.demo03.DemoAnnotation", methodName = "method1")
public class DemoAnnotationTest {

    @Test
    public void AnnotationTest() throws Exception {

        Class<DemoAnnotationTest> dat = DemoAnnotationTest.class;
        MyAnnotation atn = dat.getAnnotation(MyAnnotation.class);
        String s1 = atn.className();
        String s2 = atn.methodName();
        Class ac = Class.forName(s1);
        Object o = ac.getDeclaredConstructor().newInstance();
        Method method = ac.getMethod(s2);
        method.invoke(o);

    }
}
