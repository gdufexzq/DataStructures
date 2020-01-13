package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 9:57
 * @version V1.0
 */
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for(int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for(int i=1,j=0; i< arr.length; i++) {
            while (arr[i]-- > 0) {
                if(heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3,1};
        int count = heightChecker(heights);
        System.out.println(count);
    }
}
