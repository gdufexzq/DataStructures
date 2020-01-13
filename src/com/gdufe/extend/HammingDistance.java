package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 16:25
 * @version V1.0
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
//        String strX = "";
//        String strY = "";
//        while(x / 2 != 0) {
//            strX = (x % 2) + strX;
//            x = x / 2;
//        }
//        strX = x + strX;
//        while(y / 2 != 0) {
//            strY = (y % 2) + strY;
//            y = y / 2;
//        }
//        strY = y + strY;
//
//        if(strX.length() > strY.length()) {
//            for(int i=strY.length(); i< strX.length(); i++) {
//                strY = 0 + strY;
//            }
//        } else if(strX.length() < strY.length()) {
//            for(int i=strX.length(); i< strY.length(); i++) {
//                strX = 0 + strX;
//            }
//        }
//        int count = 0;
//        for(int i=0; i<strX.length(); i++) {
//            if(strX.charAt(i) != strY.charAt(i)) {
//                count++;
//            }
//        }
//        return count++;

        // 异或
        int i = x ^ y;
        String s = Integer.toBinaryString(i);
        int cnt = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1'){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int count = hammingDistance(93, 73);
        System.out.println(count);
    }
}
