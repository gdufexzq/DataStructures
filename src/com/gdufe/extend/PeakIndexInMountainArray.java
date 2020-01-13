package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 15:47
 * @version V1.0
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int index = 0;
        for(int i=1; i<A.length; i++) {
            if(A[i] > A[i-1]) {
                index = i;
            }
        }
        return index;
    }
}
