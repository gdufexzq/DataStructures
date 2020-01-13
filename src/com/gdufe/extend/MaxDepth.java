package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/31 10:30
 * @version V1.0
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left =  1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        if(left > right) {
            return left;
        } else {
            return right;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
