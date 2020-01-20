package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/19 15:52
 * @version V1.0
 */
public class Fib {
    public int fib(int N) {
        if(N == 0) {
            return 0;
        }
        if(N == 1) {
            return 1;
        }
        return fib(N-1) + fib(N-2);
    }
}
