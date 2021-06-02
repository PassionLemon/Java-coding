package com.example.basicDataType;

import java.util.Arrays;

/**
 * @Author: lyh
 * @Date: 2021/06/02  13:46
 * @Description:
 */
public class UseArraysTest {
    public static void main(String[] args) {
        int[] a = {11, 21, 32, 4, 9, 10};
        //快速排序排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //复制指定长度的数组
        System.out.println(Arrays.toString(Arrays.copyOf(a, 5)));

        //二分搜索算法查找key
        System.out.println(Arrays.binarySearch(a, 10));

        //所有数据元素值设置为val
        Arrays.fill(a, 10);
        System.out.println(Arrays.toString(a));

        int[][] magicSquare = {{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}};
        System.out.println(Arrays.deepToString(magicSquare));


    }
}
