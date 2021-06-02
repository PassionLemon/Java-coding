package com.example.basicDataType;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: lyh
 * @Date: 2021/06/01  18:06
 * @Description:
 */
public class UseStringTest {
    public static void main(String[] args) {
        //定义
        String e = "";
        String greeting = "Hello";

        //子串
        String s = greeting.substring(0, 3);
        System.out.println(s);

        //拼接
        String expletive = "Expletive";
        String PG13 = "PG";
        String message = expletive + PG13;
        System.out.println(message);

        //是否相等
        System.out.println("Hello".equals(greeting));
        System.out.println("Hello".equalsIgnoreCase(greeting));
        System.out.println(greeting.compareTo("Hello") == 0);

        //空串和null串
        System.out.println("空串:" + (greeting.length() == 0));
        System.out.println("空串" + (greeting.equals("")));
        System.out.println("null串:" + (greeting == null));
        System.out.println("既不是空串，也不是null串:" + (greeting != null && greeting.length() != 0));

        //码点与代代码单元
        System.out.println("length:" + greeting.length() + ",codePointCount:" + greeting.codePointCount(0, greeting.length()));

        //读取输入
        /*Scanner in = new Scanner(System.in);
        System.out.println("输入姓名");
        String name = in.nextLine();
        System.out.println("输入年龄");
        int age = in.nextInt();
        System.out.printf("Hello, %s. Next year, you'll be %d", name, age);*/

        System.out.printf("%tZ", new Date());
    }
}

