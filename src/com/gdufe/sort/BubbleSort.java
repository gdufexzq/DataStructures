/**
 * @Note Copyright (c) ${year}, CDC All Rights Reserved.
 * 注意：本内容仅限于中数通信息有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.gdufe.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @Description: 冒泡排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, -2};
//
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        //测试一下冒泡排序，给80000个数据
        // 创建随机数组
        int []arr = new int[80000];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 80000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);
        //测试 80000数据12秒
        bubbleSort(arr);

        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);


//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        // 为了容易理解，我们把冒泡排序的演变过程，给大家演示

        //第一趟排序，就是将最大的数排在最后
//        int temp = 0; // 临时变量
//        for(int j=0; j<arr.length-1-0; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第一趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第二趟排序，就是将第二大的shu排在倒数第二个
//        for(int j=0; j<arr.length-1-1; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第3趟排序，就是将第三大的数排在倒数第三个
//        for(int j=0; j<arr.length-1-2; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第三趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第4趟排序，就是将第4大的数排在倒数第4个
//        for(int j=0; j<arr.length-1-3; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第4趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
    }

    // 将前面的冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        // 冒泡排序 的时间复杂度O(n^2)
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，标识是否进行过交换
        for(int i=0; i<arr.length - 1; i++) {
            for(int j=0; j< arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.println("第" + (i+1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag) { //在一趟排序中，一次都没有进行过交换
                break;
            }
            flag = false; // 重置flag,进行下次判断
        }
    }
}
