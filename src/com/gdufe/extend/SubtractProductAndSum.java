package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 15:35
 * @version V1.0
 */
public class SubtractProductAndSum {
    /**
     * 1281
     * 整数的各位积和之差
     */
    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int mulSum = 1;
        for(int i=0,j=1; i<(n+"").length(); i++, j *=10) {
            int num = n / j  % 10;
            sum += num;
            mulSum *= num;
        }
        return mulSum - sum;
    }

    public static void main(String[] args) {
        int n = 234;
        int sum = subtractProductAndSum(234);
        System.out.println(sum);

    }
}
