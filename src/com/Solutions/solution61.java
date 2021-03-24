package com.Solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 旋转链表
 */
public class solution61 {
    public ListNode rotate(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        int length = 0;
        while (head != null) {
            deque.push(head);
            head = head.next;
            ++length;
        }
        int count = 0 ;
        while (count++ < k % length) {
            deque.offerLast(deque.pop());
        }
        ListNode root = deque.removeLast();
        ListNode node = root;
        while (!deque.isEmpty()) {
            node.next = deque.removeLast();
            node = node.next;
        }
        node.next = null;
        return root;
    }

    /**
     * 根据规律找到新的尾节点和头节点，然后将他们断开重连
     * 如果 k < n，在位置 n-k 处是新的链表头
     * 1 2 3 4 5 n=5
     * k=2， 那么 5 - 2 = 3，index为3的，也就是4，是新的链表头
     * 新的链表尾就是 n - k - 1 = 2，index为2的，也就是3，是新的链表尾
     * 如果 k >= n, 取 k % n当作新的k即可
     * @param head
     * @param k
     * @return
     */
    public ListNode rotate2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode old_tail = head;
        int n = 0 ;
        while (old_tail.next != null) {
            old_tail = old_tail.next;
            ++n;
        }
        n+=1; //上述的计算并没有包括进计算尾节点，到了尾节点就停止了。（old_tail.next != null)
        old_tail.next = head; // 头尾相接，形成一个环形链表

        ListNode new_tail = head;
        /**
         * k的新值是 k % n，这个值一定会比n小。
         * n - k - 1，就是新的链表尾
         */
        for (int i = 0; i < n - k % n - 1; ++i) {
            new_tail = new_tail.next;
        }
        // 对应的，新尾部的下一个节点就是新头部了
        ListNode new_head = new_tail.next;
        new_tail.next = null;//将环形链表从新链表的头和尾的连接处拆开

        return new_head;
    }
}
