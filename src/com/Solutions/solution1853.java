package com.Solutions;

/**
 * 剑指 25
 * 合并两个排序的链表
 * 和solution21同款
 *
 * 递归法和迭代法记忆力不强，记得复习
 *
 */
public class solution1853 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
