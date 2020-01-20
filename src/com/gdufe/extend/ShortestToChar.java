package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/19 10:04
 * @version V1.0
 */
public class ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        int pre = Integer.MIN_VALUE / 2;
        for(int i=0; i<arr.length; i++) {
            if(S.charAt(i) == C) {
                pre = i;
            }
            arr[i] = i - pre;
        }
        pre = Integer.MAX_VALUE / 2;
        for(int i=arr.length - 1; i>=0; i--) {
            if(S.charAt(i) == C) {
                pre = i;
            }
            arr[i] = arr[i] > pre - i ? pre - i : arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE / 2);

    }
}
