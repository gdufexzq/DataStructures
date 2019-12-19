package com.gdufe.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @Description: 归并排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        // 创建80000随机数组
        int []arr = new int[8000000];

        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 8000000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);

        int[] temp = new int[arr.length]; // 归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length-1, temp);

        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);

//        System.out.println("归并排序后=" + Arrays.toString(arr));
    }


    // 分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
//        while (left < right) { // 会一直循环(当条件不满足，回到上一层递归，会再做一次判断，然后条件又满足，这样会一直循环)
        if (left < right) {
            int mid = (left + right) / 2; // 中间索引
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }


    // 合并的方法
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引,end的意思
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        System.out.println("XXX");
        int i = left; // 初始化i,左边有序序列的初始索引
        int j = mid + 1; // 初始化j,右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // (一)
        // 先把左右两边(有序)的数据按照规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) { // 继续
            // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            // 即将左边的当前元素，填充到temp数组
            // 然后t++, i++
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else { // 反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // (二)
        // 把有剩余数据的一边的数据依次全部填充到temp
        while(i <= mid) { // 左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right) { // 右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }

        // (三)
        // 将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;
//        System.out.println("tempLeft=" + tempLeft + " right=" + right);
        // 第一次合并tempLeft=0,right=1 // tempLeft=2,right=3 // tl=0,right=3
        // 最后一次tempLeft=0,right=7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
