package com.example.features.defaults;

/**
 * 类优先于接口，所以将会执行MyImplement中的方法
 */
public class MyImplement2 extends MyImplement implements Interface2{
    public static void main(String[] args) {
        MyImplement2 myImplement2 = new MyImplement2();
        myImplement2.helloWorld();
    }
}
