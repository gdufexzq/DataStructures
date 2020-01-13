package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 14:50
 * @version V1.0
 */
public class CanWinNim {
    public boolean canWinNim(int n) {
        if(n % 4 == 0) {
            return false;
        }
        return true;
    }
}
