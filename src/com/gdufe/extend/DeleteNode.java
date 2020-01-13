package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 10:10
 * @version V1.0
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}

