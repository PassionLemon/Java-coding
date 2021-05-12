package com.example.features.defaults;

/**
 * Default方法
 * 在不破坏java现有实现架构的情况下能往接口里增加新方法.优化接口的同时，避免跟现有实现架构的兼容问题
 */


/*
//调用父接口实现

public class MyImplement implements Interface1{
    public static void main(String[] args) {
        MyImplement myImplement = new MyImplement();
        //直接调用helloWorld()方法
        myImplement.helloWorld();
    }
}
*/

/**
 * 同时继承两个接口,不知道该去调用Interface1的默认方法还是去调用Interface2的方法。
 * 解决方法就是在实现类中实现该方法
 */
public class MyImplement implements Interface1,Interface2{
    public static void main(String[] args) {
        MyImplement myImplement = new MyImplement();
        //直接调用helloWorld()方法
        myImplement.helloWorld();

    }

    @Override
    public void helloWorld() {
        System.out.println("hi i'm from MyImplement");

        //想调用接口Interface1中默认实现的方法helloWorld()，而不用自己实现的
        Interface1.super.helloWorld();
    }
}