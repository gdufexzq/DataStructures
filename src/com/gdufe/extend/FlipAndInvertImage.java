package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 16:52
 * @version V1.0
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] tempArr = new int[A.length][A[0].length];

        for(int i=0; i<A.length; i++) {
            for(int j=A[i].length-1,m=0; j>=0; j--,m++) {
                if(A[i][j] == 0) {
                    tempArr[i][m] = 1;
                }else {
                    tempArr[i][m] = 0;
                }
            }
        }
        return tempArr;
    }
}
