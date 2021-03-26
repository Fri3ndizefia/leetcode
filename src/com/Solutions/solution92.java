package com.Solutions;

/**
 * 翻转特定区间内的链表
 *
 */
public class solution92 {

    public ListNode reverse(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < left - 1) {
            g = g.next;
            p = p.next;
            ++step;
        }

        //g是守卫节点，p是一次挪动一次的节点。每次都把next头插法到前面，靠g链接
        for (int i = 0; i < right - left; ++i) {
            ListNode removed = p.next;
            p.next = removed.next;
            removed.next = g.next;
            g.next = removed;

        }
        return dummyHead.next;
    }


    /**
     * 官方解法。条例但是乱
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        // 像右移动 left - 1次，获得 prev 节点
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }

        // 左区域链表之头
        // 一共包含了 right-left+1 个链表节点
        // 这里获得了右节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; ++i) {
            rightNode = rightNode.next;
        }


        // 获得左节点，准备截断
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;// 后继节点

        // 截断链表出来
        pre.next = null;
        rightNode.next = null;

        // 反转过来后，leftNode作为head节点，成为了末端
        reverseLinkedList(leftNode);

        // leftNode成尾巴了，rightNode成头了
        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;


    }


    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}
