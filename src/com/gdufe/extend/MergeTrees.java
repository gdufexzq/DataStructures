package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 15:24
 * @version V1.0
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if(t1 == null && t2 == null) {
//            return null;
//        }
//
//        // 合并根节点
//        TreeNode root = new TreeNode((t1 == null ? 0 :t1.val) + (t2 == null ? 0 : t2.val));
//        root.left = mergeTrees((t1 == null ? null :t1.left), (t2 == null ? null : t2.left));
//        root.right = mergeTrees((t1 == null ? null :t1.right), (t2 == null ? null : t2.right));
//        return root;

        if(t1 != null && t2 != null) {
            // 合并根节点
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return  root;
        }
        else if(t1 == null && t2 != null) {
            return t2;
        }
        else if( t2 == null && t1 != null) {
            return t1;
        } else {
            return null;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
