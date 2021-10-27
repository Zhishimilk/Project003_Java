package com.bilibili.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DemoClass {

    // 反射 Class对象
    // 获取Class对象的方法: 类名.Class() ;  对象.getClass() ;  Class.forName("全类名(包名)");
    /*
        Class对象功能:
            ①获取成员变量:
                公开成员变量获取:
                    Field[] getFields()
                    Field getField(String name)
                所有成员变量获取:
                    Field[] getDeclaredFields()
                    Field getDeclaredField(String name)
                Field:
                    setAccessible(boolean flag) 设置访问权限修饰符安全检查
            ②获取构造方法:

                Constructor<?>[] getConstructors()
                Constructor<T> getConstructor(Class<?>... parameterTypes)

                Constructor<?>[] getDeclaredConstructors()
                Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)

                Constructor:
                    T newInstance(Object... tag)
                Class:
                    C newInstance(Object... tag)
            ③获取成员方法:

                Method[] getMethods()
                Method getMethod(String name, Class<?>... parameterTypes)

                Method[] getDeclaredMethods()
                Method getDeclaredMethod(String name, Class<?>... parameterTypes)

                Method:
                    invoke(Object o,... )
            ④获取类名:
                String getName()
    */

    public static void main(String[] args) throws Exception {

        // 获取Class对象的方法: 类名.Class() ;  对象.getClass() ;  Class.forName("全类名(包名)");
        Class<DemoPerson> dpc = DemoPerson.class;
        //---------------------------------------------------------

        DemoPerson dp = new DemoPerson();
        //①获取成员变量:
        //  Field[] getFields()
        Field[] fls = dpc.getFields();
        System.out.println(Arrays.toString(fls));
        //  Field getField(String name)
        Field name = dpc.getField("name");
        name.set(dp, "张三");
        System.out.println(name);
        System.out.println(name.get(dp));
        //  Field[] getDeclaredFields()
        Field[] ddf = dpc.getDeclaredFields();
        System.out.println(Arrays.toString(ddf));
        //  Field getDeclaredField(String name)
        Field age = dpc.getDeclaredField("age");
        age.setAccessible(true);
        Object o = age.get(dp);
        System.out.println(o);

        //---------------------------------------------------------

        // ②获取构造方法:
        //  Constructor<?>[] getConstructors()

        //  Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor<DemoPerson> ctr = dpc.getConstructor(String.class, int.class);
        System.out.println(ctr);
        DemoPerson zs = ctr.newInstance("zhangsan", 18);
        System.out.println(zs);
        DemoPerson dpn = dpc.getDeclaredConstructor().newInstance();
        //  Constructor<?>[] getDeclaredConstructors()

        //  Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)

        //---------------------------------------------------------

        //③获取成员方法:
        //  Method[] getMethods()

        //  Method getMethod(String name, Class<?>... parameterTypes)

        //  Method[] getDeclaredMethods()

        //  Method getDeclaredMethod(String name, Class<?>... parameterTypes)

        //---------------------------------------------------------
    }
}
