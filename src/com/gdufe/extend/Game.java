package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 15:17
 * @version V1.0
 */
public class Game {
    /**
     * LCP 1. 猜数字
     * @param guess
     * @param answer
     * @return
     */
    public static int game(int[] guess, int[] answer) {
        int count = 0;
        for(int i=0; i<guess.length; i++) {
            if(guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] guess = {1,2,3};
        int[] answer = {1,2,3};
        int count = game(guess, answer);
        System.out.println(count);
    }
}
