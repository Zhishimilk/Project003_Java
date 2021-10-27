package com.bilibili.test;

import com.bilibili.demo02.DemoWoman;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GreetTest {
    @Before
    public void method(){
        System.out.println("start...");
    }

    @After
    public void method1(){
        System.out.println("close...");
    }

    @Test
    public void testDemoWoman(){
        int i = 4;
        new DemoWoman().show();
        /*System.out.println("DD");*/
        Assert.assertEquals(3,i);
    }

}
