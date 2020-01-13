package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 16:22
 * @version V1.0
 */
public class MinDeletionSize {
    public static int minDeletionSize(String[] A) {
        int count = 0;
        for(int i=0; i<A[0].length(); i++) {
            for(int j=1; j<A.length; j++){
                if(A[j-1].charAt(i) > A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {"cba","daf","ghi"};
        minDeletionSize(A);
    }
}
