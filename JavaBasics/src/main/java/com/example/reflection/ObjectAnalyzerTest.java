package com.example.reflection;

import com.example.reflection.entity.Employee;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @Author: lyh
 * @Date: 2021/06/24  15:21
 * @Description:
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee harry = new Employee("潇湘暮羽",7500.d, LocalDate.of(1998,1,10));

        Class<? extends Employee> cl = harry.getClass();
        Field field = cl.getDeclaredField("name");
        //IllegalAccessException非法访问
        field.setAccessible(true);
        Object o = field.get(harry);
        System.out.println(o);

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));

        System.out.println(new ObjectAnalyzer().toString(harry));
    }
}
