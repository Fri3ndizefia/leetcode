package com.Solutions;

/**
 * 反转链表
 */

public class solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node = null;
        while(head != null){
            ListNode newNode = new ListNode(head.val, node);
            node = newNode;
            head = head.next;
        }
        return node;
    }

    public ListNode iteration(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
