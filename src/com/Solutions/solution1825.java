package com.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */

public class solution1825 {

    // 借用list 接口创建 arraylist对象，反过来拷贝。
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; --i) {
            res[list.size() - 1 - i] = list.get(i);
        }
        return res;
    }

    /**
     * 实际上所有反向弄的，考虑一下 stack
     */
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = stack.pop();
        }
        return res;
    }

}
