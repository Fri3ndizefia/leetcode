package Algorithms.Others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 型如 表达式 一般的计算器实现
 * 通用的一个双栈解法
 *
 * 支持自定义运算符，只需要在运算优先级上进行维护即可
 * 对于任何表达式而言，都是使用 nums 还有 ops 的两个栈
 * 遇到：
 *  空格：跳过
 *  （ ：直接加入ops中，等待与之匹配
 *  ） ：使用现有的nums和ops进行计算，直到遇到左边最近的一个左括号为止，结果放在nums中
 *  数字：从当前位置一直往后取，将一真个连续数字整体取出来，放入nums
 *  +—*运算符：放入ops中，在放入之前，可以算的都算掉，
 *              需要满足 栈内运算符 比 当前运算符 优先级高/同等，才可以进行运算
 *           一直算到没有操作或者遇到了左括号，计算结果放入nums
 *
 */
public class ExpressionCalculator {
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 3);
        put('^', 3);
    }};

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        char[] cs = s.toCharArray();
        int n = s.length();
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums,ops);
                    }else{
                        ops.pollLast();
                        break;
                    }
                }
            }else{
                if(isNumber(c)){
                    int u = 0;
                    int j = i;
                    while( j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                }else{
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        }else{
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while(!ops.isEmpty()) calc(nums, ops);
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if(op=='+') ans = a + b;
        else if(op == '-') ans = a - b;
        else if(op == '*') ans = a * b;
        else if(op == '/') ans = a / b;
        else if(op == '^') ans = (int) Math.pow(a, b);
        else if(op == '%') ans = a % b;
        nums.addLast(ans);
    }

    boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
