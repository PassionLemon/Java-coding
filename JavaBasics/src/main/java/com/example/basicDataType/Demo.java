package com.example.basicDataType;

/**
 * @Author: lyh
 * @Date: 2021/06/01  10:49
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Double d = 3.00;
        if (!Double.isNaN(d)) {
            System.out.println("d is  a number");
        }

        //强制类型转换
        double x =9.997;
        int nx = (int)x;
        System.out.println(nx);
        nx = (int)Math.round(x);
        System.out.println(nx);

        //300 = 1 0010 1100  byte b = 0010 1100
        byte b = (byte) 300;
        int i = b;
        System.out.println(b);

        //位运算符   &与   |或   ^异或   ~取反  << 按位左移运算符  >> 按位右移运算符  >>> 按位右移补零操作符
        byte b1 = (byte)60;
        byte b2 = (byte)13;
        //0011 1100
        //0000 1101 0011 1101 1100 0010
        System.out.println("&操作符：" + (b1&b2));
        System.out.println("|操作符：" + (b1|b2));
        System.out.println("^操作符：" + (b1^b2));
        //二进制负数转十进制   减一后取反转成十进制然后加负号   1100 0011 -> 1100 0010 -> 0011 1101 -> 61 -> -61
        System.out.println("~操作符：" + (~b1));
        System.out.println("<< 按位左移运算符：" + (b1 << 2));
        System.out.println(">> 按位右移运算符：" + (b1 >> 2));
        System.out.println(">>> 按位右移补零操作符：" + (b1 >>> 2));
    }
}
