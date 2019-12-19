package com.gdufe.extend;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: n个字符全排列
 * @author xuzq
 * @date 2019/12/11 16:54
 * @version V1.0
 */
public class pailie {
    public static void sq(char data[], int k) {
        // 打印数组的内容
        if (k == data.length) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        // 回溯时，利用k和i的不同进行交换
        // k的值是传过来的,从0开始
        // i跟k的值不一样是在for循环执行一遍之后开始的
        for (int i = k; i < data.length; i++) {
            {
                char temp = data[k];
                data[k] = data[i];
                data[i] = temp;
                System.out.printf("pre:i=%d,k=%d--%s\n", i, k, Arrays.toString(data));
            }
            sq(data, k + 1);
            // 进行排列后，还原数组
            {
                char temp = data[k];
                data[k] = data[i];
                data[i] = temp;
                System.out.printf("aft:i=%d,k=%d--%s\n", i, k, Arrays.toString(data));
            }
        }
    }

    public static void main(String[] args) {
        String yy ;
        Scanner qq = new Scanner(System.in);
//        yy = qq.next();
//        char data[] = yy.toCharArray();
        char data[] = {'1', '2', '3'};
        sq(data, 0);
    }
}
