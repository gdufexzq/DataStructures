package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/14 17:29
 * @version V1.0
 */
public class DecompressRLElist {
    public static int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i=0,j=0; i<nums.length; i = j * 2) {
            len += nums[i];
            j++;
        }
        int[] arr = new int[len];
        int index = 0;
        for(int i=0,j=0; i<nums.length; i = j * 2){
            int count = nums[i];
            int val = nums[i+1];
            while (count-- >0) {
                arr[index++] = val;
            }
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {55,11,70,26,62,64};
        decompressRLElist(arr);
    }

}
