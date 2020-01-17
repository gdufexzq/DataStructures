package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/17 17:33
 * @version V1.0
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i-1] == A[i]) {
                return A[i];

            }
        }
        return 0;
    }
}
