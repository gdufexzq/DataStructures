package com.gdufe.search;

import java.util.ArrayList;

/**
 * @Description: 二分查找算法
 * @author xuzq
 * @date 2019/12/13 14:40
 * @version V1.0
 */
public class BinarySearch {
    // 注意：数组必须有序
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
//        int[] arr = {1,1, 1, 1, 1, 2};
        int[] arr = {1,2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
//        int index = binarySearch(arr, 0, arr.length-1, 1000);
//        System.out.println("index=" + index);
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println("list=" + list);
    }

    /**
     * 二分查找
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if( left <= right) {
            int mid = (left + right) / 2;
            if(findVal > arr[mid]) {
                return binarySearch(arr, mid + 1, right, findVal);
            } else if(findVal < arr[mid]) {
                return binarySearch(arr, left, mid - 1, findVal);
            } else {
                return mid;
            }
        }
        return -1;
    }


    // 完成课后思考题
    /*
     *课后思考题：{1, 8, 10, 89, 1000, 1000, 1234} 当一个有序数组中，
     * 有多个相同值时，如何将所有的数值都查找到，比如这里的1000
     *
     * 思路分析
     * 1.在找到mid值时，不要马上返回
     * 2，向mid索引值的左边扫描，将所有满足1000，的元素下标加入到集合ArrayList
     * 3，向mid索引值的右边扫描，将所有满足1000，的元素下标加入到集合ArrayList
     * 4.将ArrayList返回
     *
     */

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        System.out.println("Hello~");
        if( left <= right) {
            int mid = (left + right) / 2;
            if(findVal > arr[mid]) {
                return binarySearch2(arr, mid + 1, right, findVal);
            } else if(findVal < arr[mid]) {
                return binarySearch2(arr, left, mid - 1, findVal);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                int tempLeft = mid - 1;
                int tempRight = mid + 1;
                while (tempLeft >= 0 && arr[tempLeft] == arr[mid]) {
                    list.add(tempLeft);
                    tempLeft--;
                }
                list.add(mid);
                while (tempRight < arr.length && arr[tempRight] == arr[mid]) {
                    list.add(tempRight);
                    tempRight++;
                }
                return list;
            }
        }
        return new ArrayList<>();
    }

}
