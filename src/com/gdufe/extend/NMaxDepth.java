package com.gdufe.extend;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/7 10:32
 * @version V1.0
 */
public class NMaxDepth {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.children != null && root.children.size() > 0) {
            int[] arr = new int[root.children.size()];
            for(int i=0; i<root.children.size(); i++) {
                arr[i] = 1 + maxDepth(root.children.get(i));
            }
            Arrays.sort(arr);
            return arr[arr.length - 1];
        }
        // root不为空，只是它的children为空,所以为1;
        return 1;
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
