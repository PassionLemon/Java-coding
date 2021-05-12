package com.example.features.lambda;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 测试引用
 */
public class TestQuote {
    /**
     * 对象::实例方法
     * Lambda 表达实体中调用方法的参数列表、返回类型必须和函数式接口中抽象方法保持一致
     */
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> consumer1 = (s) -> ps.println(s);
        consumer1.accept("consumer,1");

        Consumer<String> consumer2 = ps::println;
        consumer2.accept("consumer,2");
    }

    //Lambda 参数列表中的第一个参数是方法的调用者，第二个参数是方法的参数时，才能使用 ClassName :: Method

    /**
     * 类::静态方法
     */
    @Test
    public void test2(){
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);
        System.out.println(comparator1.compare(1,3));

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(3,1));
    }

    /**
     * 类::实例方法
     */
    @Test
    public void test3(){
        BiPredicate<String,String> biPredicate1 = (x,y) -> x.equals(y);
        System.out.println(biPredicate1.test("a","b"));

        BiPredicate<String,String> biPredicate2 = String::equals;
        System.out.println(biPredicate2.test("c","c"));
    }


    /**
     * 构造器引用
     * ClassName :: new
     * 需要调用的构造器的参数列表要与函数时接口中抽象方法的参数列表保持一致
     */
    @Test
    public void test4(){
        Supplier<List> supplier1 = () -> new ArrayList();
        Supplier<List> supplier2 = ArrayList::new;
    }

    /**
     * 数组引用
     * Type[]::new
     */
    @Test
    public void test5(){
        Function<Integer,String[]> function1 = x -> new String[x];
        Function<Integer,String[]> function2 = String[]::new;
        String[] strArr = function2.apply(5);
        System.out.println(strArr.length);
    }
}
