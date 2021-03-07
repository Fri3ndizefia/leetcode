package com.Solutions;

/**
 * 链表的插入排序
 * dummyHead 用于在head前插入节点，初始 dummyHead.next = head
 * lastSorted 赋予有序链表中的最后一个
 * prev 赋予有序链表中 最后一个小于 插入节点的值，插入前， prev prev next ，，，，， 插入后 prev curr prev.next
 * 通过while去找到prev
 * lastSorted.next = curr.next;
 * curr.next = prev.next;
 * prev.next = curr;
 *
 *
 * dummyHead -> head ->        x -> y -> z -> null
 *              lastSorted    curr
 *      prev 需要自己去遍历查找
 * 下一次的查找和对比，curr = lastSorted.next;
 */
import com.Solutions.ListNode;

public class solution147 {
    public ListNode insertionSortList(ListNode head){
        if(head == null) return null;
        ListNode dummyHead =  new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null ) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            }else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;

            }
            curr = lastSorted.next;
        }

        return dummyHead.next;
    }
}
