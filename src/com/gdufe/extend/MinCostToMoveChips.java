package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/8 15:54
 * @version V1.0
 */
public class MinCostToMoveChips {

    public static int minCostToMoveChips(int[] chips) {
       int ji = 0;
       int ou = 0;
       for(int i=0; i<chips.length; i++) {
           if(chips[i] % 2 == 0) {
               ou++;
           } else {
               ji++;
           }
       }
       if(ji > ou) {
           return ou;
       } else {
           return ji;
       }
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,3,3};
        int count = minCostToMoveChips(arr);
        System.out.println(count);
    }
}
