package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 10:33
 * @version V1.0
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int lcount = 0;
        int rcount = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if((s.charAt(i)+"").equals("L")) {
                lcount++;
            } else {
                rcount++;
            }
            if(lcount == rcount) {
                count++;
                lcount = 0;
                rcount = 0;
            }
        }
        return count;
    }
}
