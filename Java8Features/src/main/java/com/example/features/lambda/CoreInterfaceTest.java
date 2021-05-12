package com.example.features.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 测试Java内置的四大核心函数式接口
 */
public class CoreInterfaceTest {
    /**
     *Consumer消费型接口,对类型为T的对象应用操作：void accept(T t)
     */
    @Test
    public void test1(){
        Consumer<Integer> consumer = (x) -> System.out.println("消费型接口"+x);
        consumer.accept(3);
    }

    /**
     * Supplier提供型接口,返回类型为T的对象：T get()
     */
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1,2,3);
        list.addAll(integers);

        Supplier<Integer> supplier = () ->(int)(Math.random()*10);
        list.add(supplier.get());
        System.out.println(supplier);
        for(Integer integer: list){
            System.out.println(integer);
        }
    }

    /**
     * Function<T, R>函数型接口,对类型为T的对象应用操作，并返回结果为R类型的对象：R apply(T t)
     */
    @Test
    public void test3(){
        String str = "asdfpasdfhsd";
        Function<String,String> function = (s) -> s.substring(1,s.length()-1);
        System.out.println(function.apply(str));
    }

    /**
     * Predicate 断言型接口,确定类型为T的对象是否满足某约束，并返回boolean值：boolean test(T t)
     */
    @Test
    public void test4(){
        Integer age = 35;
        Predicate<Integer> predicate = (i) -> i >= 35;
        if(predicate.test(50)){
            System.out.println("你该退休了");
        }else{
            System.out.println("你还年轻");
        }
    }
}
