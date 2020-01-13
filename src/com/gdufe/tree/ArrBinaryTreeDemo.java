package com.gdufe.tree;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/9 15:48
 * @version V1.0
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();
//        System.out.println();
//        arrBinaryTree.infixOrder();
//        System.out.println();
//        arrBinaryTree.postOrder();
//        System.out.println();
        Node root = null;
        root = arrBinaryTree.createTreeByOrder(root,0);
        arrBinaryTree.preOrderBycursion(root);
    }
}
// 编写一个ArrBinaryTree,实现顺序存储二叉树遍历

class ArrBinaryTree {

    private int[] arr; // 存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }
    public void infixOrder() {
        this.infixOrder(0);
    }
    public void postOrder() {
        this.postOrder(0);
    }

    // 编写一个方法，完成顺序存储二叉树的前序遍历
    /**
     * @param index 数组下标
     */
    public void preOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.print(arr[index] + " ");
        // 向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        // 向左递归遍历
        if (index * 2 + 1 < arr.length) {
            infixOrder(index * 2 + 1);
        }
        // 输出当前这个元素
        System.out.print(arr[index] + " ");
        // 向右递归
        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        // 向左递归遍历
        if (index * 2 + 1 < arr.length) {
            postOrder(index * 2 + 1);
        }
        // 向右递归
        if (index * 2 + 2 < arr.length) {
            postOrder(index * 2 + 2);
        }
        // 输出当前这个元素
        System.out.printf(arr[index] + " ");
    }

    /**
     * 通过前序遍历创建二叉树
     * @param root
     * @param index
     * @return
     */
    public Node createTreeByOrder(Node root, int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("无法创建二叉树");
        }
       root = new Node(arr[index]);
        if(index * 2 + 1 < arr.length) {
            root.left = createTreeByOrder(root.left, index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length) {
           root.right = createTreeByOrder(root.right, index * 2 + 2);
        }
        return root;
    }

    public void preOrderBycursion(Node root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preOrderBycursion(root.left);
            preOrderBycursion(root.right);
        }
    }
}

class Node {
    int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
