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
     * @param args
     */

    public static void main(String[] args) {
        int x =5;
        System.out.println(x/ 2);
    }
}
