package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 11:49
 * @version V1.0
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        for(int i=0; i<A.length; i++) {
            A[i] = (int) Math.pow(Math.abs(A[i]), 2);
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {

    }
}
