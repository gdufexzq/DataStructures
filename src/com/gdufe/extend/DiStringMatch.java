package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 14:33
 * @version V1.0
 */
public class DiStringMatch {
    public int[] diStringMatch(String S) {
        int min = 0;
        int max = S.length();
        int[] A = new int[S.length() + 1];
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == 'D'){
                A[i] = max--;
            } else {
                A[i] = min++;
            }
        }
        A[S.length()] = max;
        return A;
    }

    public static void main(String[] args) {

    }
}
