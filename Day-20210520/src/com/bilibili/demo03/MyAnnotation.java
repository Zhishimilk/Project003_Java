package com.bilibili.demo03;

import java.lang.annotation.*;

/**
 * 元注解:
 *    @Target: 描述注解作用域
 *    @Retention: 描述注解被保留阶段
 *    @Documented: 描述注解是否被抽取到Api文档中
 *    @Inherited: 描述注解是否被子类继承
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String className();
    String methodName();
}
