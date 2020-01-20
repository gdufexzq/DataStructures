package com.gdufe.extend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/19 16:01
 * @version V1.0
 */
public class NumSpecialEquivGroups {
    public static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i) {
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    public static void main(String[] args) {
        String arr[] = {"abc","acb","bac","bca","cab","cba"};
        numSpecialEquivGroups(arr);
    }


}
