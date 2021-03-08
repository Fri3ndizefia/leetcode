package com.Solutions;

/**
 * 反转链表
 * 将 next 指向 前一个即可，通过迭代法
 */

public class solution1836 {
    public ListNode reverseList(ListNode head) {
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
