package com.suzhoukeleqi.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;


public class Test01 {

    @MyAnnotaiton(age = 18)
    public static void test1() {
//        System.out.println("njynb");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //test1();
        Class<?> aClass = Class.forName("com.suzhoukeleqi.test.User");
        System.out.println(aClass);
        User o = (User) aClass.getDeclaredConstructor().newInstance();
        System.out.println(o.getAge());

    }
}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotaiton {
    String name() default "";
    int age();
    int id() default -1;
    String[] schools() default {"a","b"};
}