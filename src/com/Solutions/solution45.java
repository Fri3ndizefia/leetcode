package com.Solutions;

/**
 * DP篇
 *
 * 跳跃游戏
 */
public class solution45 {
    /**
     * 每次都能跳到终点，可以用贪心思想，从终点往出发点走
     *
     * 这里 每次寻找到 能最终一下跳到终点的下标，把它的位置定在新的终点
     * 一直循环知道 position < 0
     *
     * 时间复杂度 n^2
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; ++i) {
                if(i + nums[i] >= position){
                    position = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
}
