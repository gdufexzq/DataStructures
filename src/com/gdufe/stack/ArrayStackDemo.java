package com.gdufe.stack;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

        // 测试一下
        // 先创建一个栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出栈的数据：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~");

    }
}
// 定义一个ArrayStack 表示栈
class ArrayStack {

    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈-push
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈-pop
    public int pop() {
        if (isEmpty()) {
            // 抛异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top--];
        return value;
    }

    // 显示栈的情况【遍历栈】，遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i=top; i>=0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}

