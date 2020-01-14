package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/13 11:34
 * @version V1.0
 */
public class CountPrimeSetBits {

    public static int countPrimeSetBits(int L, int R) {
        int count = 0;
        int sum = 0;
        for(int i = L; i <= R; i++) {
            String str = Integer.toBinaryString(i);
            // 统计1的个数，然后判断1的个数之和是否是质数
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '1') {
                    sum++;
                }
            }
//            System.out.println(sum + " " + isZhi(sum));
            if(isZhi(sum)) {
                count++;
            }
            sum = 0;
        }
        return count;
    }

    public static boolean isZhi(int sum) {
        if(sum == 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(sum); i++) {
            if(sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = countPrimeSetBits(842, 888);
        System.out.println(count);

    }
}
