package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 15:22
 * @version V1.0
 */
public class NumJewelsInStones {

    /**
     * 771 宝石与石头
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i=0; i< J.length(); i++) {
            char c = J.charAt(i);
            int index = S.indexOf(c);
            if(index != -1) {
                count++;
                while (true) {
                    int index2 = S.indexOf(c, index + 1);
                    if(index2 == -1) {
                        break;
                    } else {
                        count++;
                        index = index2;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int count = numJewelsInStones(J, S);
        System.out.println(count);
    }
}
