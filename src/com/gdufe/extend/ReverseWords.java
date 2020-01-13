package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 15:53
 * @version V1.0
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder words = new StringBuilder("");
        for(int i=0; i<str.length; i++) {
            words.append(new StringBuilder(str[i]).reverse());
            if(i != str.length-1) {
                words.append(" ");
            }
        }
        return words.toString();
    }
}
