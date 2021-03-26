package com.Solutions;

/**
 * 删除链表中的重复的元素。
 * 删除掉多余的，使元素只有它自身一个;
 */
public class solution83 {

    /**
     * 和82同款思路
     * 区别在于 head = 和 head.next =
     * head = 意味着跳过所有的重复链表
     * head.next = 意味着第一个重复的（head）保留，并且链接到下一个去了
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        if(head.val == next.val){
            while(next != null && head.val == next.val ){
                next = next.next;
            }
            head.next = deleteDuplicates(next); // 这里唯一与82题不同的位置
        }else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    /**
     * 顺序链表
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null ) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }

}
