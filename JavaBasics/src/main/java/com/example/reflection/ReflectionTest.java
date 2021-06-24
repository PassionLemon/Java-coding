package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @Author: lyh
 * @Date: 2021/06/24  11:51
 * @Description:
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入class名字,例如: java.util.Date");
            name = scanner.nextLine();
        }

        try {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();

            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println("class " + name);


            //显示继承父类的信息
            if (superCl != null && superCl != Object.class) {
                System.out.println("extends " + superCl.getName());
            }

            //显示构造器、域、方法
            System.out.print("\n{\n     构造器:\n");
            printConstructors(cl);
            System.out.print("\n     域:\n");
            printMethods(cl);
            System.out.print("\n     方法:\n");
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造器
     */
    public static void printConstructors(Class cl) {
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            String name = constructor.getName();
            System.out.print("     ");
            //getModifiers修饰符
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            //getParameterTypes 构造方法参数
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(parameterTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 方法
     */
    public static void printMethods(Class cl) {
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?> returnType = method.getReturnType();
            String name = method.getName();

            System.out.print("     ");

            String moditiers = Modifier.toString(method.getModifiers());
            if (moditiers.length() > 0) {
                System.out.print(moditiers + " ");
            }
            System.out.print(returnType.getName() + " " + name + "(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(parameterTypes[j]);
            }
            System.out.println(");");
        }
    }

    /**
     * 域
     */
    public static void printFields(Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();

        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            String name = field.getName();
            System.out.print("     ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
