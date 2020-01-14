package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/13 11:54
 * @version V1.0
 */
public class TitleToNumber {
    public static int titleToNumber(String s) {
        int sum = 0;
        for(int i=s.length()-1,j=0; i>=0; i--,j++) {
            int count = (int) ((s.charAt(i) - 'A' + 1) * Math.pow(26, j));
            sum +=count;
        }
        return sum;
    }

    public static void main(String[] args) {
        int ab = titleToNumber("ZY");
        System.out.println(ab);
    }
}
