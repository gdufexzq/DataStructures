package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/8 17:03
 * @version V1.0
 */
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if(root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}