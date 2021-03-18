package com.Solutions;

/**
 * 奇偶分离链表
 */
public class solution328 {
    public ListNode oddEvenList(ListNode head){
        if (head == null ) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
