package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 10:51
 * @version V1.0
 */
public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        if(root.val > R) {
            return  rangeSumBST(root.left, L, R);
        } else if(root.val < L) {
            return  rangeSumBST(root.right, L, R);
        } else{
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(10);
//        TreeNode temp = treeNode;
//        treeNode.left = new TreeNode(5);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(7);
//        treeNode.right = new TreeNode(15);
//        treeNode.right.right = new TreeNode(18);
//        int sum = rangeSumBST(treeNode, 7, 15);
//        System.out.println(sum);

        TreeNode treeNode = new TreeNode(18);
        TreeNode temp = treeNode;
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(15);
        treeNode.left.right.left = new TreeNode(12);
        treeNode.right = new TreeNode(27);
        treeNode.right.left = new TreeNode(24);
        treeNode.right.left.left = new TreeNode(21);
        treeNode.right.right = new TreeNode(30);
        int sum = rangeSumBST(treeNode, 18, 24);
        System.out.println(sum);

    }
}
