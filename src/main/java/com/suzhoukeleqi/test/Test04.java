package com.suzhoukeleqi.test;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class person = Class.forName("com.suzhoukeleqi.test.Person");
        Annotation[] annotations = person.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Field[] fields = person.getDeclaredFields();
        System.out.println((fields == null));
        System.out.println(fields.length);
        for (Field field : fields) {
            Colnjy annotation = field.getAnnotation(Colnjy.class);
            System.out.println(annotation.colname());
            System.out.println(annotation.coltype());
            System.out.println(annotation.collength());
        }
    }
}


@Data
@Tablenjy("db_person")
class Person{
    @Colnjy(colname = "db_name", coltype = "varchar", collength = 10)
    private String name;
    @Colnjy(colname = "db_age", coltype = "int", collength = 10)
    private int age;
    @Colnjy(colname = "db_id", coltype = "int", collength = 10)
    private int id;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablenjy{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Colnjy{
    String colname();
    String coltype();
    int collength();
}