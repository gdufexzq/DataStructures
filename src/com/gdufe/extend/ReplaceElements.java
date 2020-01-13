package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/30 10:12
 * @version V1.0
 */
public class ReplaceElements {
    public static int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for(int i=arr.length-2; i>=0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if(temp > max) {
                max = temp;
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] ints = replaceElements(arr);
        System.out.println(Arrays.toString(ints));
    }
}
