package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 16:06
 * @version V1.0
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for(int i=0,j=s.length-1; i<=j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {

    }
}
