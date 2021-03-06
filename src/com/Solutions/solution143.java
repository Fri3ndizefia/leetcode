package com.Solutions;

import java.util.ArrayList;
import java.util.List;

/***
 * 重排链表
 * 0, 1, 2, 3, ..., n-2, n-1, n
 * 0, n, 1, n-1, 2, n-2, 3,..
 */
public class solution143 {
  /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
  public class ListNode{
      int val;
      ListNode next;
      public ListNode(){}
      public ListNode(int val){
          this.val = val;}

      public ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }


  }

    /***
     * 不管三七二十
     * 把链表直接塞进arraylist 去通过下标访问
     * 找到规则重新排列就好了
     * @param head
     */

    public void reorderList(ListNode head) {
        if (head == null) {
            return ;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int length = list.size();
        int i = 0, j = length - 1;
        while(i < j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next=null;

    }

    /***
     * 第二种方法
     * 找到中点，左半段和 翻转过的右半段进行合并
     *
     * @param head
     */

    public void reorderListPLUS(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reversListNode(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reversListNode(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        return  prevNode;
    }
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }


    public static void main(String[] args) {
        int x =5;
        System.out.println(x/ 2);
    }
}
