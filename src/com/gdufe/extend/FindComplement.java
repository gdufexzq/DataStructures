package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/3 17:43
 * @version V1.0
 */
public class FindComplement {
    public static int findComplement(int num) {
//        System.out.println(Integer.toBinaryString((int)Math.pow(2, Integer.toBinaryString(num).length()) - 1));
        Integer count = num ^ (int)(Math.pow(2, Integer.toBinaryString(num).length()) - 1);
//        System.out.println(count);
//        String s = Integer.toBinaryString(count);
//        System.out.println(s);
        return count;
    }

    public static void main(String[] args) {
        int complement = findComplement(0);
    }
}
