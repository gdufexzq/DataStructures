package com.gdufe.extend;

import java.util.ArrayList;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 15:51
 * @version V1.0
 */
public class GetDecimalValue {
    /**
     * 1290. 二进制链表转整数
     */
    public static int getDecimalValue(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if(head != null) {
                int val = head.val;
                list.add(val);
                head = head.next;
            } else {
                break;
            }
        }
        int sum=0;
        for(int i=list.size()-1,j=0; i>=0; i--,j++) {
            if(list.get(i) != 0) {
                sum += Math.pow(2, j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        ListNode temp = listNode.next;
        temp.next = new ListNode(1);
        int value = getDecimalValue(listNode);
        System.out.println(value);

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
