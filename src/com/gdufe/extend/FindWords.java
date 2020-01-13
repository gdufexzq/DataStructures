package com.gdufe.extend;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/3 16:43
 * @version V1.0
 */
public class FindWords {
    public static String[] findWords(String[] words) {
        String s1 = "QWERTYUIOPqwertyuiop";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "ZXCVBNMzxcvbnm";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            boolean flag = true;
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            for(int j=0; j<words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if(s1.contains(ch+"")) {
                   count1++;
                } else if(s2.contains(ch+"")) {
                    count2++;
                } else if(s3.contains(ch+"")) {
                    count3++;
                }
            }
            if(!(count1 >=1 && (count2 >=1 || count3 >= 1)
                    || count2 >= 1 && (count1 >= 1 && count3 >= 1)
                    || count3 >=1 && (count1 >=1 || count2 >= 1))) {
                list.add(words[i]);
            }
        }
        String[] str = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = findWords(s);
        System.out.println(Arrays.toString(words));
    }
}

