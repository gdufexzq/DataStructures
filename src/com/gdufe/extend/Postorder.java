package com.gdufe.extend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 11:00
 * @version V1.0
 */
public class Postorder {

    // 递归法
    static ArrayList<Integer> list = new ArrayList<>();
    public static List<Integer> postorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.children != null && root.children.size() > 0) {
            for(int i=0; i< root.children.size(); i++){
                postorder(root.children.get(i));
            }
        }
        list.add(root.val);
        return list;
    }

    // 非递归法, 前序遍历反转就是后续(N叉树)
    public List<Integer> postorder2(Node root) {
        List<Integer> res_pre = new ArrayList<>();
        if(root == null) {
            return res_pre;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node n = s.pop();
            res_pre.add(n.val);
            for(Node node : n.children) {
                s.push(node);
            }

        }
        Collections.reverse(res_pre);
        return res_pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node.children = new ArrayList<>();
        node.children.add(node3);
        node.children.add(node2);
        node.children.add(node4);
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        List<Integer> list = postorder(node);
        System.out.println(list);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
