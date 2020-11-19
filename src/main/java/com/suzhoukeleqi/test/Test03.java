package com.suzhoukeleqi.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test03 {
    public void a1(List<User> l, Map<String,User> m,int age){}

    public Map<String,User> a2(){return null;}

    public static void main(String[] args) throws NoSuchMethodException {
        //获取Test03.a1()的所有参数的类型的数组（包括泛型），其中包含了两个泛型
        Type[] b = Test03.class.getMethod("a1", List.class,Map.class,int.class).getGenericParameterTypes();
        for (Type type : b) {
            //是泛型的情况
            if(type instanceof ParameterizedType){
                //强转成泛型，取出泛型的实际类型
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        System.out.println("====================");
        //获取Test03.a2()的返回值的类型（包括泛型），其中包含了一个泛型
        Type c = Test03.class.getMethod("a2", null).getGenericReturnType();
        if(c instanceof ParameterizedType){
            //强转成泛型，取出泛型的实际类型
            Type[] actualTypeArguments = ((ParameterizedType) c).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }



    }
}
