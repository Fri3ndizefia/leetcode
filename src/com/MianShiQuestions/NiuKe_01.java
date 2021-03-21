package com.MianShiQuestions;

/**
 * 庆祝61儿童节
 *
 * 牛家庄幼儿园为庆祝61儿童节举办庆祝活动,庆祝活动中有一个节目是小朋友们围成一个圆圈跳舞。
 * 牛老师挑选出n个小朋友参与跳舞节目,已知每个小朋友的身高h_i。
 * 为了让舞蹈看起来和谐,牛老师需要让跳舞的圆圈队形中相邻小朋友的身高差的最大值最小,
 * 牛老师犯了难,希望你能帮帮他。
 * 如样例所示:
 * 当圆圈队伍按照100,98,103,105顺时针排列的时候最大身高差为5,其他排列不会得到更优的解
 *
 */



//这个很简单啊！怎么样身高差最小呢？就是两身高差不多的人站一起咯，小时候站队 老师总让
//矮的站中间高的站两边，就是这个道理，如 9 8 7 6 6 7 8 9然后9和9再拉手不就可以了吗 ！所以
//将数据输入一个数组如【8 9 7 6 5 4 3 2】然后排序【2 3 4 5 6 7 8 9】然后遍历数组进入
//一个队列一个栈 现规定，索引为0,2,4，，，的依次进入队列Q1，索引为1,3,5，，，，的依次进入//栈S1，就形成一个队列2 4 6 8 （队列尾为8）和一个栈3 5 7 9（栈顶为9） 。然后出栈9 7 5 3
//依次进入队列尾 形成 2 4 6 8 9 7 5 3 就排队成功，2和3拉手就成圈，求每个元素与挨着的
//距离就可以了
import java.io.*;
import java.util.*;

public class NiuKe_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> h = new ArrayList<>();
        for (String s : br.readLine().split(" ")) {
            h.add(Integer.parseInt(s));
        }
        Collections.sort(h);
        List<Integer> array = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < h.size(); ++i) {
            if (i % 2 == 0) {
                array.add(h.get(i));
            }else{
                stack.push(h.get(i));
            }
        }
        while (!stack.isEmpty()) {
            array.add(stack.pop());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size() - 1; ++i) {
            if (Math.abs(array.get(i + 1) - array.get(i)) > max) {
                max = Math.abs(array.get(i + 1) - array.get(i));
            }
        }
        System.out.println(array);
        System.out.println(max);
    }
}