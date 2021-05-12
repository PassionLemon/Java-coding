package com.example.features.optional;

import com.example.features.optional.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @Author: lyh
 * @Date: 2021/05/12  10:59
 * @Description: Optional创建方式
 */
public class CreateOptional {
    /**
     * 创建一个空的 Optional 实例
     */
    @Test
    public void testCreate1() {
        Optional<Object> empty = Optional.empty();
        System.out.println("empty = " + empty);
    }

    /**
     * of()方法与ofNullable()方法的区别
     * of()方法中不可以传入为null的值，不然会报空指针异常
     * ofNullable()方法允许传入null值，如果传入值为null则返回一个Optional.empty()
     */
    @Test
    public void testCreate2() {
        Employee employee = new Employee();
        Optional<Employee> employee1 = Optional.of(employee);
        System.out.println("employee1 = " + employee1);
    }

    @Test
    public void testCreate3() {
        Employee employee = new Employee();
        Optional<Employee> employee1 = Optional.ofNullable(employee);
        System.out.println("employee1 = " + employee1);
    }
}
