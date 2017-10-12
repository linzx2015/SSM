package com.lzx.ssm.common.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.*;
/**
 * 切换数据源注解
 * ElementType.TYPE,ElementType.METHOD
 * 执行的位置是在类或接口上,如果挂在方法和参数上会出现错误;
 * RetentionPolicy.SOURCE ：这种类型的Annotations只在源代码级别保留,编译时就会被忽略 
   RetentionPolicy.CLASS ： 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略 
   RetentionPolicy.RUNTIME ： 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
   Inherited 注解可被子类继承
 * @author lzx
 * */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource 
{
    public static String ONE = "ds_one";
 
    public static String TWO = "ds_two";

	String value() default DataSource.ONE;
}