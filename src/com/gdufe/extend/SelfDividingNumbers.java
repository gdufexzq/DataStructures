package com.gdufe.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 9:38
 * @version V1.0
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=left; i<=right; i++) {
            String str = i + "";
            boolean flag = true;
            for(int j=0, k=1; j<str.length(); j++, k *= 10) {
                int digit = i / k % 10;
                if(digit == 0 || i % digit != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(i);
            }
        }
        return list;
    }
}
