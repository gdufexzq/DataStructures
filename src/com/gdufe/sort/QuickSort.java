/**
 * @Note Copyright (c) ${year}, CDC All Rights Reserved.
 * 注意：本内容仅限于中数通信息有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.gdufe.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Description: 快速排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class QuickSort {
    public static void main(String[] args) {
//        int arr[] = {-9, 78, 0, 23, -567, 70};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println("arr=" + Arrays.toString(arr));

        // 创建80000随机数组
        int []arr = new int[8000000];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 80000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);
        quickSort(arr, 0, arr.length-1); //
        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {

        int l = left; // 左下标
        int r = right; // 右下标
        // pivot 中轴值
        int pivot = arr[(left+right) / 2];
        int temp;
        // while 循环的目的是让比pivot值小放到左边
        // 比pivot值大放到右边
        while (l < r) {

            // 在pivot的左边一直找，找到大于等于pivot的值，才退出
            while(arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果l >= r,说明pivot的左右两边的值，已经按照左边全是小于等于pivot的值
            // 右边全是大于等于pivot的值
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 下面的两个if是必须要加的,否则-9, 0, 0, 23, -567, 70这种情况会出现死循环
            // 如果交换完，发现这个arr[l] == prvot的值 相等 r--, 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            // 如果交换完后，发现这个arr[r] == pivot值 相等 l++, 后移
            if(arr[r] == pivot) {
                l += 1;
            }

        }
        // 如果l == r ,必须l++,r--,否则为出现栈溢出
        if(l == r) {
            l += 1;
            r -= 1;
        }
        // 后面两个if是为了结束递归
        // 向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }

    }
}
