package com.example.features.lambda;

import com.example.features.defaults.Interface1;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 参数列表的数据类型可省略
 * 因为JVM可以通过上下文推断出数据类型
 */
public class UseLambdaTest {
    /**
     * 匿名内部类
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    //简化1
    @Test
    public void test2(){
        Comparator<Integer> com = (o1,o2 )->Integer.compare(o1,o2);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //简化2
    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    @Test
    public void test4(){
        //无参,无返回值
        Runnable run = () -> System.out.println("Hello,Lambda");
        run.run();

        //匿名内部类引用外部变量必须要用final，jdk1.8开始可省略final，但还是final变量
        int num = 0;
        Runnable runnable = () -> System.out.println("Hello,Lambda!"+num);
        runnable.run();

        //1个参,无返回值
        //Consumer<String> consumer = (x) -> System.out.println(x);
        //Consumer<String> consumer = x -> System.out.println(x);
        Consumer<String> consumer = System.out::println;
        consumer.accept("test");

        //2个及以上参数，并且 Lambda 体中有多条语句
        //单个参数可省略圆括号，多条语句必须要花括号
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println(x+","+y);
            return Integer.compare(x,y);
        };
        System.out.println(comparator.compare(3,4));
    }

    @Test
    public void test05(){
        MyFun myFun1 = (a,b) -> a+b;
        MyFun myFun2 = (a,b) -> a-b;
        MyFun myFun3 = (a,b) -> a*b;
        MyFun myFun4 = (a,b) -> a/b;

    }

    public Integer operation(Integer a, Integer b, MyFun myFun){
        return myFun.count(a,b);
    }
    @Test
    public void test06(){
        Integer result = operation(3,5,(x,y) -> x+y);
        System.out.println(result);
    }


    List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44)
    );
    @Test
    public void test07(){
        Collections.sort(emps,(e1,e2)->{
            if(e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp: emps) {
            System.out.println(emp);
        }
    }
}
