/**
 * @Note Copyright (c) ${year}, CDC All Rights Reserved.
 * 注意：本内容仅限于中数通信息有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.gdufe.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @Description: 插入排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,109,1, -1, 89};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        // 创建80000随机数组
        int []arr = new int[80000];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 80000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);
        insertSort(arr); // 1秒
        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);
//        System.out.println(Arrays.toString(arr));
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        // 使用逐步推导的方法来讲解

        // 第1轮 {101,34,109,1} => {34,101,109,1};

        // {101,34,109,1} => {101,101,109,1};
        // 定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; // 即arr[1]的前面这个数的下标
//
//        // 给isnertVal 找到插入的位置
//        // 说明
//        // 1. insertIndex >= 0 保证给insertVal 找插入的位置不越界
//        // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入的位置
//        // 3. 就需要将arr[insertIndex]后移
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; // arr[insertIndex]
//            insertIndex--;
//        }
////        当退出while循环时，说明插入的位置找到，insertIndex+1
//        // 举例：理解不了，我们一会debug
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第1轮插入后");
//        System.out.println(Arrays.toString(arr));
//
//        // 第2轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1; // 即arr[1]的前面这个数的下标
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; // arr[insertIndex]
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第2轮插入后");
//        System.out.println(Arrays.toString(arr));
//
//        // 第3轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1; // 即arr[1]的前面这个数的下标
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; // arr[insertIndex]
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第3轮插入后");
//        System.out.println(Arrays.toString(arr));


        // 插入排序
        for(int i=1; i<arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            // 如果有序数组的最后一个元素比待插入的数大，则该元素后移
            while (insertIndex >=0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex+1] = insertVal;
            }

//            System.out.println("第" + i + "轮");
//            System.out.println(Arrays.toString(arr));
        }
    }
}
