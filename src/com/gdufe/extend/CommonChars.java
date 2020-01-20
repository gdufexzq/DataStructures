package com.gdufe.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/19 10:52
 * @version V1.0
 */
public class CommonChars {
    public static List<String> commonChars(String[] A) {
        int[][] arr = new int[A.length][26];
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[i].length(); j++) {
                int temp = A[i].charAt(j) - 'a';
                arr[i][temp]++;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        int min=0;
        for(int i=0; i<26; i++) {
            boolean flag = true; // 是否是第一次比较
            for(int j=1; j<A.length; j++) {
               if(arr[j-1][i] > arr[j][i]) {
                   if(flag) {
                       min = arr[j][i]; // 是第一次比较
                       flag = false;
                   } else {
                       if(min > arr[j][i]) {
                           min = arr[j][i];
                       }
                   }
               } else {
                   if(flag) {
                       min = arr[j-1][i]; // 是第一次比较
                       flag = false;
                   } else { 
                       if(min > arr[j-1][i]) {
                           min = arr[j-1][i];
                       }
                   }
               }
            }
            if(min > 0) {
                for(int m=0; m<min; m++) {
                    char ch = (char) ('a' + i);
                    list.add(ch + "");
                }
            }
            min = 0;
        }
        return list;
    }

    public static void main(String[] args) {
        String a[] = {"cool","lock","cook"};
//        String a[] = {"bella","label","roller"};
        commonChars(a);
    }
}
