package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/20 14:43
 * @version V1.0
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String S) {
        boolean flag = false;

        while (true) {
            for(int i=1; i<S.length(); i++) {
                if(i == S.length() - 1) {
                    flag = true;
                }
                if(S.charAt(i-1) == S.charAt(i)) {
                    String temp = "";
                    if(i-1 > 0) {
                        temp = S.substring(0, i-1);
                    }
                    if(i+1 < S.length()) {
                        temp += S.substring(i+1, S.length());
                    }
                    S = temp;
                    break;
                }
            }
            if(flag || S.length() <= 1) {
                break;
            }
        }
        return S;
    }


    public static void main(String[] args) {

        String str = "abbaca";
        String s = "bb".substring(0, 2);
        System.out.println(s);
        removeDuplicates(str);
    }
}
