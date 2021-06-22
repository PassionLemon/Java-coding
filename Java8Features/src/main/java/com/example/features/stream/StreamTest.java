package com.example.features.stream;

import com.example.features.stream.entity.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lyh
 * @Date: 2021/05/12
 * @Description: Stream的使用
 */
public class StreamTest {
    List<Person> personList = Arrays.asList(
        new Person("Tom", 8900, 23, "male", "New York"),
        new Person("Jack", 7000, 25, "male", "Washington"),
        new Person("Lily", 7800, 28, "female", "Washington"),
        new Person("Anni", 8200, 24, "female", "New York"),
        new Person("Owen", 9500, 25, "male", "New York"),
        new Person("Alisa", 7800, 26, "female", "New York")
    );

    /**
     * 遍历(foreach)
     */
    @Test
    public void testForeach(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // forEach()方法需要传一个Consumer<T>消费性接口
        list.stream().forEach((x) -> System.out.println(x));
    }

    /**
     * 匹配(match)
     */
    @Test
    public void testMatch(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // anyMatch()方法中需要传一个断言型接口Predicate<T>
        // 判断集合中是否有大于6的数据，有就返回true否则返回false
        boolean anyMatch = list.stream().anyMatch((x) -> x > 6);
        System.out.println("anyMatch = " + anyMatch);
        // allMatch()方法中需要传一个断言型接口Predicate<T>
        // 判断集合中是否所有的数据都大于6，如果都大于6返回true否则返回false
        boolean allMatch = list.stream().allMatch((x) -> x > 6);
        System.out.println("allMatch = " + allMatch);
    }

    /**
     * 筛选(filter)
     */
    @Test
    public void testFilter(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // filter()方法中需要传一个断言型的接口Predicate<T>
        // filter((x) -> x > 7) 过滤出集合中大于7的数据返回新的流再遍历
        list.stream().filter((x) -> x > 7).forEach((y) -> System.out.println(y));
    }

    /**
     * 聚合(max/min/count)
     */
    @Test
    public void testMax(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        /**
         * max()方法中需要一个函数式接口Comparator<T>
         * comparing方法中需要一个函数型接口Function<T, R>
         * Optional类后面会讲到
         */
        Optional<String> max = list.stream().max(Comparator.comparing((x) -> {
            return x.length();
        }));
        // 简写形式
        Optional<String> max1 = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }

    @Test
    public void testMax2(){
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("自然排序最大值：" + max.get());
    }

    @Test
    public void testMin(){
        Optional<Person> min = personList.stream().min(Comparator.comparing(Person::getSalary));
        System.out.println("员工工资最小值：" + min.get().getSalary());
    }

    @Test
    public void testCount() {
        long count = personList.stream().filter(person -> person.getSalary() > 8000).count();
        System.out.println("工资大于8000的个数" + count);
    }

    /**
     * 映射(map/flatMap)
     */
    @Test
    public void testMapAndFlatMap() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        list.stream().map(s -> s.split(",")).forEach(x -> System.out.println((Arrays.toString(x))));
        list.stream().flatMap(s -> Stream.of(s.split(","))).forEach(x -> System.out.println("x = " + x));
    }

    /**
     * 归集(toList/toSet/toMap)
     */
    @Test
    public void testToList() {
        List<Integer> toCollect = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listCollect = toCollect.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        for (Integer integer : listCollect) {
            System.out.println("List: integer = " + integer);
        }
    }
    @Test
    public void testToSet() {
        List<Integer> toCollect = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        Set<Integer> setCollect = toCollect.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        for (Integer integer : setCollect) {
            System.out.println("Set: integer = " + integer);
        }
    }

    @Test
    public void testToMap() {
        printList(personList);
        Map<String, Integer> map = personList.stream().filter(s -> s.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, Person::getSalary));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("姓名:" + entry.getKey() + ",工资:" + entry.getValue());
        }
    }

    /**
     * 统计(count/averaging)
     */
    @Test
    public void testCountAndAveraging() {
        Long personCount = personList.stream().count();
        Long personCounting = personList.stream().collect(Collectors.counting());
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        Long sum = personList.stream().collect(Collectors.summingLong(Person::getSalary));
        DoubleSummaryStatistics summaryStatistics = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工总数：" + personCount + "," + personCounting);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工最高工资：" + max.get());
        System.out.println("员工工资之和：" + sum);
        System.out.println("员工所有信息：" + summaryStatistics);
    }

    /**
     * 分组(partitioningBy/groupingBy)
     */
    @Test
    public void testGroup() {
        printList(personList);
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        for (Map.Entry<Boolean, List<Person>> entry : part.entrySet()) {
            System.out.println("key为" + entry.getKey() + "value为" + entry.getValue().toString());
        }
        Map<String, List<Person>> sexGroup = personList.stream().collect(Collectors.groupingBy(x -> x.getSex()));
        for (Map.Entry<String, List<Person>> entry : sexGroup.entrySet()) {
            System.out.println("key为" + entry.getKey() + "value为" + entry.getValue().toString());
        }
        Map<String, Map<String, List<Person>>> sexAndAreaGroup = personList.stream().collect(Collectors.groupingBy(x -> x.getSex(),
                Collectors.groupingBy(y -> y.getArea())));
        for (Map.Entry<String, Map<String, List<Person>>> entry : sexAndAreaGroup.entrySet()) {
            String key = entry.getKey();
            Map<String, List<Person>> value = entry.getValue();
            for (Map.Entry<String, List<Person>> listEntry : value.entrySet()) {
                System.out.println("性别为" + key + ",地区为" + listEntry.getKey() + ",集合为" + listEntry.getValue().toString());
            }
        }
    }

    /**
     * 接合(joining)
     */
    @Test
    public void testJoin() {
        String joinName = personList.stream().map(x -> x.getName()).collect(Collectors.joining(","));
        System.out.println(joinName);
    }

    /**
     * 排序(sorted)
     */
    @Test
    public void testSorted() {
        printList(personList);
        // 按工资增序排列
        List<String> sorted = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("sorted = " + sorted);
        // 按工资降序排列
        List<String> reversed = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("reversed = " + reversed);
        // 先按工资再按年龄自然排序（从小到大）
        List<String> salaryAndAgeReversed = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("salaryAndAgeReversed = " + salaryAndAgeReversed);
        // 先按工资再按年龄自定义排序（从大到小）
        List<String> list1 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("list1 = " + list1);
    }

    /**
     * 合并流(concat)
     */
    @Test
    public void testConcat() {
        List<String> collect = Stream.concat(personList.stream(), personList.stream()).map(Person::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 去重(distinct)
     */
    @Test
    public void testDistinct() {
        List<Integer> collect = Stream.concat(personList.stream(), personList.stream()).map(Person::getSalary).distinct().collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 限制(limit)
     */
    @Test
    public void testLimit() {
        List<String> collect = Stream.concat(personList.stream(), personList.stream()).map(Person::getName).limit(3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 跳过(skip)
     */
    @Test
    public void testSkip() {
        List<String> collect = Stream.concat(personList.stream(), personList.stream()).map(Person::getName).skip(2).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 归约(reduce)
     */
    @Test
    public void testReduce() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //求和
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);
        int sum1 = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("sum1 = " + sum1);

        //最大值
        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("max = " + max);
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);
        System.out.println("max1 = " + max1);

        //最小值
        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);
        System.out.println("min = " + min);
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);
        System.out.println("min1 = " + min1);

        //拼接字符串
        String[] strings = {"a", "b", "c", "d", "e"};
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
        System.out.println("reduce = " + reduce);
        String reduce1 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });
        System.out.println("reduce1 = " + reduce1);
    }


    /**
     * 打印集合
     * @param personList
     */
    public static void printList(List<Person> personList){
        for (int i = 0; i < personList.size(); i++){
            System.out.println(personList.get(i).toString());
        }
    }
}
