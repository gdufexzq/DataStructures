package com.gdufe.extend;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 15:44
 * @version V1.0
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
