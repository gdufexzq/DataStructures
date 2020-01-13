package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/8 15:27
 * @version V1.0
 */
public class SmallestRangeI {
    // 一个数组，加上X，求最小差值
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        if(min + K >= max - K) {
            return 0;
        } else {
            return (max - K) - (min + K);
        }
    }
}
