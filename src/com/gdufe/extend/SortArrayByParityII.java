package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/8 15:45
 * @version V1.0
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for(int i=0; i<A.length; i++) {
            if(i%2 == 0) {
                int temp = A[i];
                int index = i;
                while (A[index] % 2 != 0) {
                    index++;
                }
                if(i != index) {
                    A[i] = A[index];
                    A[index] = temp;
                }
            } else {
                int temp = A[i];
                int index = i;
                while (A[index] % 2 == 0) {
                    index++;
                }
                if(i != index) {
                    A[i] = A[index];
                    A[index] = temp;
                }
            }
        }
        return A;
    }

}
