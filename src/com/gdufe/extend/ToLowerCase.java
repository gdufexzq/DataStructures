package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 15:08
 * @version V1.0
 */
public class ToLowerCase {
    public static String toLowerCase(String str) {
        String temp = "";
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                temp += (char)(str.charAt(i) + 32);
            } else {
                temp += str.charAt(i) + "";
            }
        }
        return temp;
    }

    public static void main(String[] args) {// a-z 97,97+25(122),
        // A-Z 97-32(65), 97-32+25(90)
        System.out.printf("%c\n",97+25);
        System.out.println((int)'a' - 'A');
        System.out.printf("%c\n",97-32+25);

        String s = toLowerCase("Aabc#ewr");
        System.out.println(s);
    }
}
