package com.Solutions;

/**
 * 反转链表
 */

public class solution206 {

    /**
     * 头插法
     * 0 -> 1 -> 2 -> 3
     * 1 -> 0 -> 2 -> 3
     * 2 -> 1 -> 0 -> 3
     * 3 -> 2 -> 1 -> 0
     * 就将 p 设置 0，每次p的下一个节点，插入头部（头的前面可以拿个dummyHead，做连接用）
     * ListNode removed = p.next;
     * p.next = removed.next;
     * removed.next = dummyHead.next;
     * dummyHead.next = removed;
     * 注意插入的时候，处理连接，要从右往左连接起来。
     *
     * 将 p 设置为其他的起始节点，同时设置一定的步长限制，可以保证 在链表的一定范围内进行反转
     * 详情见题目 solution92
     * @param head
     * @return
     */
    public ListNode reverseList_toucha(ListNode head) {
        if(head == null) return null;
        ListNode dummyTail = new ListNode(-1);
        ListNode p = head;
        dummyTail.next = head;
        while(p.next != null){
            ListNode removed = p.next;
            p.next = removed.next;
            removed.next = dummyTail.next;
            dummyTail.next = removed;
        }
        return dummyTail.next;
    }

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
