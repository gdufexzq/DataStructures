package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 17:08
 * @version V1.0
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if(A[i] % 2 != 0) {
                while (i < j && A[j--] % 2 != 0) {

                }
                int temp = A[i];
                A[i] = A[j+1];
                A[j+1] = temp;
            }
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] ints = sortArrayByParity(A);
        System.out.println(Arrays.toString(ints));
    }
}
