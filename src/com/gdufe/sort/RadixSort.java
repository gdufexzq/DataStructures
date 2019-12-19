package com.gdufe.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description: 基数排序
 * @author xuzq
 * @date 2019/12/11 14:38
 * @version V1.0
 */
public class RadixSort {

    public static void main(String[] args) {
//        int arr[] = {53, 3, 542, 748, 14, 214};

        // 创建80000000随机数组
        // 11个数组所占内存
        // int类型占4个字节，11个数组 80000000 * 11 * 4 共有多少字节
        // / 1024 为多少kb
        // / 1024 / 1024 为多少M
        // / 1024 / 1024 / 1024 为多少G
        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 = 3.3G
        int []arr = new int[8000000];

        for(int i=0; i<arr.length;i++) {
            arr[i] = (int)(Math.random() * 8000000); // 生成一个[0, 80000)的数
        }

        Date start = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = sdf.format(start);
        System.out.println("排序前的时间是=" + startStr);

        radixSort(arr);

        Date end = new Date();
        String endStr = sdf.format(end);
        System.out.println("排序后的时间是=" + endStr);

//        System.out.println("基数排序后=" + Arrays.toString(arr));
    }

    // 基数排序方法

    /**
     * 如果存在负数，需要做一个数据预处理，因为这个基数排序只能做整数排序，
     * 所以如果数组存在负数，需要找到数组中最小的负数，
     * 然后整个数组加上最小负数的绝对值，然后进行排序，
     * 排序完，
     * 在整个数组减去最小负数绝对值
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        // 说明
        // 1.二维数组包含10个一维数组
        // 2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length
        // 3.很明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        // 可以这样理解
        // 比如：bucketElementCounts[0], 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        // 根据前面的推导过程，我们可以得到最终的基数排序代码

        // 1.得到数组中最大的数的位数
        int max = arr[0]; // 假设第一个数就是最大数
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //得到最大数是几位数
        int maxLength = (max + "").length();

        // 这里我们使用循环将代码处理
        for(int i=0, n=1; i< maxLength; i++, n *= 10) {
            // 第1轮(针对每个元素的相应位数进行排序处理)
            for(int j=0; j<arr.length; j++) {
                // 取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
//                int digitOfElement = arr[j] / (int)Math.pow(10, i) % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index = 0;
            // 遍历每一遍桶，并将桶中的数据，放入原数组
            for(int k=0; k < bucketElementCounts.length; k++) {
                // 如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    // 循环该桶即第k个桶(即第k个一维数组),放入
                    for(int l=0; l<bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr,第k个桶的l个元素
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                // 第1轮处理后，需要将每个buckedElementCounts[k] = 0 !!!
                bucketElementCounts[k] = 0;
            }
//            System.out.printf("第%d轮，对个位的排序处理 arr = %s\n", i+1, Arrays.toString(arr));
        }

        /*// 第1轮(针对每个元素的个位数进行排序处理)
        for(int j=0; j<arr.length; j++) {
            // 取出每个元素的个位的值
            int digitOfElement = arr[j] / 1 % 10;
            // 放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
        int index = 0;
        // 遍历每一遍桶，并将桶中的数据，放入原数组
        for(int k=0; k < bucketElementCounts.length; k++) {
            // 如果桶中，有数据，我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                // 循环该桶即第k个桶(即第k个一维数组),放入
                for(int l=0; l<bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr,第k个桶的l个元素
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            // 第1轮处理后，需要将每个buckedElementCounts[k] = 0 !!!
            bucketElementCounts[k] = 0;
        }

        System.out.println("第1轮，对个位的排序处理 arr = " + Arrays.toString(arr));

        //========================================

        // 第2轮(针对每个元素的十位数进行排序处理)
        for(int j=0; j<arr.length; j++) {
            // 取出每个元素的个位的值
//            int digitOfElement = arr[j]  % 100 / 10;
            int digitOfElement = arr[j] / 10 % 10;
            // 放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
        index = 0;
        // 遍历每一遍桶，并将桶中的数据，放入原数组
        for(int k=0; k < bucketElementCounts.length; k++) {
            // 如果桶中，有数据，我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                // 循环该桶即第k个桶(即第k个一维数组),放入
                for(int l=0; l<bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr,第k个桶的l个元素
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            // 第2轮处理后，需要将每个buckedElementCounts[k] = 0 !!!
            bucketElementCounts[k] = 0;
        }

        System.out.println("第2轮，对个位的排序处理 arr = " + Arrays.toString(arr));



        // 第3轮(针对每个元素的百位数进行排序处理)
        for(int j=0; j<arr.length; j++) {
            // 取出每个元素的个位的值
            int digitOfElement = arr[j]  / 100 % 10;
            // 放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
        index = 0;
        // 遍历每一遍桶，并将桶中的数据，放入原数组
        for(int k=0; k < bucketElementCounts.length; k++) {
            // 如果桶中，有数据，我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                // 循环该桶即第k个桶(即第k个一维数组),放入
                for(int l=0; l<bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr,第k个桶的l个元素
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            // 第3轮处理后，需要将每个buckedElementCounts[k] = 0 !!!
            bucketElementCounts[k] = 0;
        }

        System.out.println("第3轮，对个位的排序处理 arr = " + Arrays.toString(arr));*/

    }
}
