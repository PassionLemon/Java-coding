package com.example.debug;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lyh
 * @Date: 2021/05/31  12:00
 * @Description:
 */
public class UseDebugTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("debug demo start...");
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前值：" + i);
        }
        System.out.println("debug demo end...");
    }
}
