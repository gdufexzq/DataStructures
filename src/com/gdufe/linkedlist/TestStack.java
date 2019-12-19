package com.gdufe.linkedlist;

import java.util.Stack;

// 演示栈stack的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
