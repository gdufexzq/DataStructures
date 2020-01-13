package com.gdufe.extend;

import java.util.*;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 11:16
 * @version V1.0
 */
public class Preorder {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        /*ArrayList<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for(int i=node.children.size()-1; i>=0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;*/
        if(root == null) {
            return new ArrayList<>();
        }
        // 递归
        list.add(root.val);
        if(root.children != null && root.children.size() > 0) {
            for(int i=0; i<root.children.size(); i++) {
                preorder(root.children.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
    class Node {
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
    };
}
