package com.gdufe.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/14 16:33
 * @version V1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        Node root = createHuffmanTree(arr);

        preOrder(root);

    }

    // 编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if(root == null) {
            System.out.println("是空树，不能遍历");
        } else {
            root.preOrder();
        }
    }

    // 创建赫夫曼树
    public static Node createHuffmanTree(int[] arr) {
        // 第一步 为了操作方便
        // 1. 遍历arr数组
        // 2. 将arr的每个元素构造成一个Node
        // 3. 将Node放入到ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();

        for(int val : arr) {
            Node node = new Node(val);
            nodes.add(node);
        }

        // 我们处理的过程是循环
        while (nodes.size() > 1) {
            // 排序 从小到大
            Collections.sort(nodes);

//            System.out.println(nodes);

            // 取出根节点权值最小的两颗二叉树
            // (1) 取出权值最小的节点（二叉树）
            Node leftNode = nodes.get(0);
            // (2) 取出权值第二小的节点（二叉树）
            Node rightNode = nodes.get(1);

            // (3) 构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // (4) 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // (5) 将parent加入到nodes
            nodes.add(parent);

        }
        // 返回哈夫曼树的root节点
        return nodes.get(0);
    }
}

// 创建节点类
// 为了让Node 对象支持Collections集合排序
// 让Node 实现 Comparable接口
class Node implements Comparable<Node> {
    int value; // 节点权值
    char c; // 字符
    Node left; // 指向左子节点
    Node right; // 指向右子节点

    // 前序遍历 67,29,38,15,7,8,23,10,4,1,3,6,13
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}
