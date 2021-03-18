package com.Solutions;

/**
 * 字节跳动算法题 排序奇升偶降链表
 *
 * 分为三个步骤
 * 1.拆开奇链表和偶链表
 * 2.翻转偶链表，让偶链表也成为升序链表
 * 3.合并链表
 *
 * 第一步 solution 328
 * 第二步 solution 206
 * 第三步 solution 21
 */
public class ByteDance_01 {

    /**
     * 步骤一，奇偶链表分离。 记得给odd链表填上最后的 null
     * @param head
     * @return
     */
    private ListNode[] partition(ListNode head) {
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        return new ListNode[]{head, evenHead};
    }


    /**
     * 步骤二，倒置链表，获取升序的偶链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 步骤三，迭代法 合并有序链表
     * @param p
     * @param q
     * @return
     */
    private ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(-1);
        ListNode r = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        r.next = p == null ? q : p;

        return head.next;
    }

    public ListNode sortOddEvenList(ListNode root){
        if (root == null || root.next == null) {
            return root;
        }
        ListNode[] temp = partition(root);
        ListNode oddList = temp[0];
        ListNode evenList = temp[1];
        return merge(oddList, reverse(evenList));

    }

}
