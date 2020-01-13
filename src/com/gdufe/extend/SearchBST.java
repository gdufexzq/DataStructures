package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 10:40
 * @version V1.0
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        /*if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode tempLeft = searchBST(root.left, val);
        // 左递归找到，就不用右递归
        if(tempLeft != null) {
            return tempLeft;
        } else {
            TreeNode tempRight = searchBST(root.right, val);
            if(tempRight != null) {
                return tempRight;
            }
        }
        return null;*/


        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
