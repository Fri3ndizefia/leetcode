package com.Solutions;

public class solution82 {
    public ListNode deleteDuplicates(ListNode node){
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode prev = head;
        ListNode LastSingleNode = head;
        while(node != null){
            prev = node;
            node = node.next;
            if(node == null){
                break;
            }

            if (prev.val != node.val) {
                LastSingleNode = prev;
            }else {
                ListNode diff = node;
                while( diff.val == node.val ){
                    diff = diff.next;
                    if(diff == null){
                        break;
                    }
                }
                LastSingleNode.next = diff;
                node = diff;
            }
        }
        return head.next;
    }

    public static ListNode delete(ListNode head){
        if (head == null || head.next == null) {
            return head; // base case
        }

        ListNode next = head.next;
        if(head.val == next.val){
            while(next!=null && head.val == next.val){
                next = next.next;
            }
            head = delete(next);
        } else{
            head.next = delete(next);
        }
        return head;
    }
}
