package com.example.features.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author: lyh
 * @Date: 2021/05/12  14:05
 * @Description:
 */
public class Time {
    /**
     * 传统的日期格式化
     */
    @Test
    public void testTradition() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Callable<Date> task = () -> simpleDateFormat.parse("20200517");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        ArrayList<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(pool.submit(task));
        }

        for (Future<Date> future : result) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
    }

    /**
     * LocalDate 日期，格式为：yyyy-MM-dd
     * LocalTime 时间，格式为：HH:mm:ss SSS
     * LocalDateTime 日期时间，格式为：yyyy-MM-ddTHH:mm:ss SSS ,是前2者的结合
     * Instant 时间戳
     * Duration 持续时间，时间差
     * Period 时间段
     * ZoneOffset 时区偏移量，比如：+8:00
     * ZonedDateTime 带时区的时间
     * Clock 时钟，比如获取目前美国纽约的时间
     * java.time.format.DateTimeFormatter 时间格式化
     */
    @Test
    public void testNewDate() {
        //日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //+1天
        System.out.println(localDate.plusDays(1));
        //-1天
        System.out.println(localDate.minusDays(1));
        String currdate = DateTimeFormatter.ofPattern("MM-dd").format(localDate);
        System.out.println(currdate);

        //时间
        //当前 日期时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.plusHours(1));

        //日期+时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //自定义日期
        LocalDate date = LocalDate.of(2018, 2, 6);
        System.out.println("自定义日期:" + date);

        //判断日期是否相等
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2021, 5, 11);
        if(date1.equals(date2)) {
            System.out.println("日期相等");
        }else {
            System.out.println("日期不相等");
        }

        //计算一周后的日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期为:" + today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:" + nextWeek);

        //判断日期范围
        LocalDate tomorrow = LocalDate.of(2021, 5, 13);
        if(tomorrow.isAfter(today)){
            System.out.println("之后的日期:" + tomorrow);
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("之前的日期:" + yesterday);
        }

        //日期格式化
        String dayAfterTommorrow = "20210512";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow + " 格式化后的日期为: " + formatted);

        //字符串、日期互转
        LocalDateTime dateTime1 = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String str = dateTime1.format(format1);
        System.out.println("日期转换为字符串:" + str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDateTime dateTime2 = LocalDateTime.parse(str, format2);
        System.out.println("字符串转日期:" + dateTime2);

        //日期格式更换
        String endDate = "2021-05-19";
        LocalDate dateTime = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String s = dateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println("日期格式更换：" + s);
    }

}
