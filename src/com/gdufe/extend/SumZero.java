package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/16 17:09
 * @version V1.0
 */
public class SumZero {
    public static int[] sumZero(int n) {
        int arr[] = new int[n];
        int mid = n / 2;

        if(n % 2 != 0) {
            int temp = mid + 1;
            arr[0] = 0;
            for(int i=1; i<=mid; i++) {
                arr[i] = -i;
                arr[temp++] = i;
            }
        } else {
            int temp = mid;
            for(int i=0; i<mid; i++) {
                arr[i] = -(i + 1);
                arr[temp++] = i + 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = sumZero(4);
        System.out.println(Arrays.toString(ints));
    }

}
