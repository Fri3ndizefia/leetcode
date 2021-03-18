package com.Solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表检测
 * 把 ListNode这个对象放进 哈希集合 中去
 * 这样就可以检测到是否有环形情况，不用担心值重复，因为放进去的是对象
 */
public class solution141 {
    public boolean hasCycle(ListNode head){
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if(!seen.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
