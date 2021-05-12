package com.example.features.optional;

import com.example.features.optional.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: lyh
 * @Date: 2021/05/12  11:12
 * @Description: Option类中方法的使用
 */
public class UseOptionalMethod {
    /**
     * get()
     * 返回Optional中存储的任意类型的值
     * 如果Optional中的值为null，调用get()方法时则抛出 java.util.NoSuchElementException
     */
    @Test
    public void testGet() {
        Optional<String> stringOptional = Optional.ofNullable("hello");
        System.out.println("stringOptional = " + stringOptional.get());

        Optional<Integer> integerOptional = Optional.of(100);
        System.out.println("integerOptional = " + integerOptional.get());

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<List<Integer>> listOptional = Optional.of(list);
        System.out.println("listOptional = " + listOptional.get());
    }

    /**
     * ifPresent(Consumer<? super T> consumer)
     * 如果值存在，执行Consumer的具体操作，如果不存，不做任何操作
     * 搭配Optional.ofNullable使用
     * Optional.of如果有null会报空指针异常
     */
    @Test
    public void testIfPresent() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional.ofNullable(list).ifPresent(System.out::println);
        Optional.ofNullable(null).ifPresent(System.out::println);
        //Optional.of(null).ifPresent(System.out::println);
    }

    /**
     * isPresent()
     * 如果存在值则返回true，否则返回false
     */
    @Test
    public void testIsPresent() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean present = Optional.ofNullable(list).isPresent();
        System.out.println("present = " + present);
        List<Integer> list1  = null;
        boolean present1 = Optional.ofNullable(list1).isPresent();
        System.out.println("present1 = " + present1);
    }

    /**
     * ilter(Predicate<? super T> predicate)
     * 根据传入的 Predicate 对 Optional 中的值进行过滤
     * 满足条件则返回该 Optional 对象，否则返回一个空的 Optional
     */
    @Test
    public void testFilter() {
        Optional<Integer> integer = Optional.ofNullable(5).filter(num -> num > 3);
        System.out.println(integer.get());
        Optional<Integer> integer2 = Optional.ofNullable(1).filter(num -> num > 3);
        System.out.println(integer2.get());
    }

    /**
     * map(Function<? super T, ? extends U> mapper)
     * 如果 Optional 有值，则执行 mapper 映射函数，并获取其返回值
     * 如果返回值不为 null，则返回一个包含返回值的 Optional 对象，否则返回一个空的 Optional 对象
     */
    @Test
    public void testMap() {
        Employee employee = new Employee();
        employee.setName("xxmy");
        Optional<String> nameOptional = Optional.ofNullable(employee).map(entity -> entity.getName());
        System.out.println("name = " + nameOptional.get());
    }

    /**
     * flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)
     * 功能与 map 类似,区别在于 map 的 mapper 映射函数可返回任意数据类型
     * 但是 flatMap 的 mapper 映射函数只能返回 Optional 类型。
     */
    @Test
    public void testFlatMap() {
        Employee employee = new Employee();
        employee.setName("xxmy");
        Optional<String> nameOptional = Optional.ofNullable(employee).flatMap(entity -> Optional.ofNullable(entity.getName()));
        System.out.println("name = " + nameOptional.get());
    }

    /**
     * orElse(T other)
     * 如果optional的值存在则返回，否则返回other
     */
    @Test
    public void testOrElse() {
        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.orElse("value is null"));
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("value is null"));
    }

    /**
     * orElseGet(Supplier<? extends T> supplier)
     * 功能与 orElse 类似，区别在于 orElse 可直接返回某个值
     * orElseGet 需要执行 supplier，并返回其结果
     */
    @Test
    public void testOrElseGet() {
        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.orElseGet(() -> "value is null"));
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.orElseGet(() -> "value is null"));
    }

    /**
     *  orElseThrow()
     *  如果只存在则返回，否则抛出返回的异常
     */
    @Test
    public void testOrElseThrow() {
        Optional<Integer> optional = Optional.ofNullable(1);
        System.out.println(optional.orElseThrow(() -> new RuntimeException()));
        Optional<Object> optional1 = Optional.ofNullable(null);
        System.out.println(optional1.orElseThrow(() -> new RuntimeException()));
    }
}