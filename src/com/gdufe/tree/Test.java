package com.gdufe.tree;

import java.util.ArrayList;

/**
 * @Description: 数组扩容
 * @author xuzq
 * @date 2019/12/19 15:16
 * @version V1.0
 */
public class Test {
    public static void main(String[] args) {
        // 以ArrayList为例，看看时怎么进行数组扩容的
        // ArrayList 维护了数组 transient Object[] elementData
        // int newCapacity = oldCapacity + (oldCapacity >> 1); >> 右移一位，相当于/2,所以时原来的1.5倍
        ArrayList list = new ArrayList<>();
    }
}
