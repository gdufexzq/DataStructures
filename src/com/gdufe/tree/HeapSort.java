package com.gdufe.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/14 14:54
 * @version V1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        // 要求将数组进行升序排列
//        int[] arr = {4, 6, 8, 5, 9};
//        int[] arr = {4, 6, 8, 5, 9, -1, 90, 89, 56, -999};

        // 创建80000随机数组
        int []arr = new int[8000000];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 8000000); // 生成一个[0, 8000000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);
        heapSort(arr);
        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);

//        System.out.println("数组 = " + Arrays.toString(arr));
    }

    // 编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("堆排序！！");


//        // 分步完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr)); // 4,9,8,5,6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr)); // 9,6,8,5,4


        // 完成我们的最终代码
        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        // 最后一个非叶子节点的下标i = arr.length / 2 - 1
        for(int i = arr.length / 2 - 1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /**
         * (2) 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
         * (3) 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整
         *      + 交换步骤，直到整个序列有序
         */
        int temp = 0;
        // i > 0 而不是>=0 是因为当为0时，只有一个元素了，没必要再排序
        for(int i = arr.length - 1; i>0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 这里传过去的i一直为0，是因为只变动了堆顶元素，其他位置的局部堆没变，只要把堆顶重新调整
            // 就整体又是大顶堆或小顶堆
            adjustHeap(arr, 0, i);
        }
    }

    // 将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成将以 i 对应的非叶子节点的树调整成大顶堆
     *
     * 举例：int[] arr = {4, 6, 8, 5, 9}  => i = 1 => adjustHeap => 得到 {4,9,8,5,6}
     * 如果我们再次调用adjustHeap传入的是i=0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5,4}
     * @param arr 待调整数组
     * @param i 表示非叶子节点在数组中索引
     * @param length 表示对多少个元素进行调整，length在逐渐减少
     */
    public static void  adjustHeap(int arr[], int i, int length) {
        int temp = arr[i]; // 先取出当前元素的值，保存为临时变量
        // 开始调整
        // 说明
        // 1. k = i * 2 + 1 是i节点的左子节点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k+1]) { // 说明左子节点的值小于右子节点的值
                k++; // k指向右子节点
            }
            if(arr[k] > temp) { // 如果子节点大于父节点
                arr[i] = arr[k]; // 把较大的值赋给当前节点
                i = k; // !!! i 指向 k, 继续循环比较
            } else {
                break; // 可以break是因为是下往上比较
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树的值最大化，放在了最顶（局部）
        arr[i] = temp; // 将temp值放到调整后的位置
    }
}
