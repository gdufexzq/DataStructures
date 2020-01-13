package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 14:55
 * @version V1.0
 */
public class FindNumbers {

    /**
     * 1295. 统计位数为偶数的数字
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     * 输入：nums = [12,345,2,6,7896]
     * 输出：2
     * 解释：
     * 12 是 2 位数字（位数为偶数） 
     * 345 是 3 位数字（位数为奇数）  
     * 2 是 1 位数字（位数为奇数） 
     * 6 是 1 位数字 位数为奇数） 
     * 7896 是 4 位数字（位数为偶数）  
     * 因此只有 12 和 7896 是位数为偶数的数字
     *
     * @param nums
     * @return
     */
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int num = (nums[i] + "").length();
            if(num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int count = findNumbers(nums);
        System.out.println(count);
    }
}
