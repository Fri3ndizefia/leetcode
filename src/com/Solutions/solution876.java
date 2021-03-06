package com.Solutions;

/***
 * 寻找链表中点
 * 数组法
 * 单指针法
 * 快慢指针法
 */
public class solution876 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        // public ListNode middleNode(ListNode head) {
        //     ListNode node = head;
        //     List<ListNode> list = new ArrayList<ListNode>();
        //     while(node != null){
        //         list.add(node);
        //         node = node.next;
        //     }
        //     // int n = (list.size() % 2 == 1) ? list.size()/2 : list.size()/2 ;
        //     return list.get(list.size()/2);
        // }

        // public ListNode middleNode(ListNode head){
        //     ListNode node = head;
        //     int n = 0;
        //     while(node != null){
        //         n++;
        //         node=node.next;
        //     }
        //     int k = 0;
        //     node = head;
        //     while(k < n/2){
        //         k++;
        //         node = node.next;
        //     }
        //     return node;
        // }
//
//        public ListNode middleNode(ListNode head){
//            ListNode slow = head, fast = head;
//            while(fast != null && fast.next != null){
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            return slow;
//        }
    }
}
