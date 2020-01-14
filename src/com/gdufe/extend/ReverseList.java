package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/13 10:52
 * @version V1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode node = head;
        ListNode temp = head.next;
        head = temp;
        node.next = null;
        // 1->2->3->4->5->null
        while (temp != null) {
           temp = head.next;
           head.next = node;
           node = head;
           head = temp;
        }
        return node;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
