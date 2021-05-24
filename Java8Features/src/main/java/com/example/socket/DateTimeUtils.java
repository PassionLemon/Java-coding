package com.example.socket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: lyh
 * @Date: 2021/05/24  17:19
 * @Description:
 */
public class DateTimeUtils {

    public static String getDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒");
        return dtf.format(dateTime);
    }
}
