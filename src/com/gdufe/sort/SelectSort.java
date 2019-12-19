/**
 * @Note Copyright (c) ${year}, CDC All Rights Reserved.
 * 注意：本内容仅限于中数通信息有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.gdufe.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @Description: 选择排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};

        // 创建80000随机数组
        int []arr = new int[800000];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 800000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);
        selectSort(arr); // 3秒
        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);

//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
    }

    // 选择排序
    public static void selectSort(int[] arr) {

        // 使用逐步推导的方式来，讲解选择排序

        // 第一轮：
        // 原始的数组: 101,34,119,1
        // 第一轮排序: 1,34,119,101
        // 算法：先简单-》再复杂，就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决

        // 第1轮
        int minIndex = 0;
        int min = arr[0];

//        for(int j = 0 + 1; j<arr.length; j++) {
//            if(min > arr[j]) { // 说明假定的最小值，并不是最小
//                min = arr[j]; // 重置min
//                minIndex = j; // 重置index
//            }
//        }
//        // 将最小值，放在arr[0],即交换
//        if(minIndex != 0) {
//            arr[minIndex] = arr[0];
//            arr[0] = min;
//        }
//
//
//        System.out.println("第1轮后~");
//        System.out.println(Arrays.toString(arr)); // 1, 34, 119, 101
//
//
//        // 第2轮
//        minIndex = 1;
//        min = arr[1];
//
//        for(int j = 1 + 1; j<arr.length; j++) {
//            if(min > arr[j]) { // 说明假定的最小值，并不是最小
//                min = arr[j]; // 重置min
//                minIndex = j; // 重置index
//            }
//        }
//        // 将最小值，放在arr[1],即交换
//        if(minIndex != 1) {
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//
//
//        System.out.println("第2轮后~");
//        System.out.println(Arrays.toString(arr)); // 1, 34, 119, 101
//
//
//        // 第3轮
//        minIndex = 2;
//        min = arr[2];
//
//        for(int j = 1 + 1; j<arr.length; j++) {
//            if(min > arr[j]) { // 说明假定的最小值，并不是最小
//                min = arr[j]; // 重置min
//                minIndex = j; // 重置index
//            }
//        }
//        // 将最小值，放在arr[2],即交换
//        if(minIndex != 2) {
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }
//
//
//        System.out.println("第3轮后~");
//        System.out.println(Arrays.toString(arr)); // 1, 34, 119, 101


        for(int i=0; i<arr.length-1; i++) {
            minIndex = i;
            min = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                if(min < arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第" + i+1 + "轮后~");
//            System.out.println(Arrays.toString(arr)); // 1, 34, 119, 101
        }

    }
}
