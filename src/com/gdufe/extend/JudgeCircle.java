package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 9:32
 * @version V1.0
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int l = 0;
        int r = 0;
        int u = 0;
        int d = 0;
        for(int i=0; i<moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    l++;
                    break;
                case 'R':
                    r++;
                    break;
                case 'U':
                    u++;
                    break;
                case 'D':
                    d++;
                    break;
                default:
                    break;
            }
        }
        if(l - r == 0 && d - u == 0) {
            return true;
        } else {
            return false;
        }
    }
}
