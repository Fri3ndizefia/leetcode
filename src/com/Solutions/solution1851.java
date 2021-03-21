package com.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 22
 * 链表中的倒数第k个节点
 *
 * 考察次数：1
 */

public class solution1851 {
    public ListNode getKthFromEnd(ListNode head, int K) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size()  - K);
    }

    /**
     * 快慢指针法
     * slow在0
     * fast置于 slow + k处
     * 然后共同移动
     * 当fast等于null的时候，slow就是倒数第K了
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
