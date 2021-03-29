package com.Solutions;

/**
 * 跳跃游戏三
 */
public class solution1306 {
    public boolean canReach(int[] nums, int start) {
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, start, visited);
    }

    /**
     * visited 确保不会无限循环下去浪费
     * 同时可以减少递归堆栈。
     * @param nums
     * @param index
     * @param visited
     * @return
     */
    public boolean dfs(int[] nums, int index, boolean[] visited) {
        if( index < 0 || index >= nums.length || visited[index]) return false;
        if(nums[index] == 0) return true;
        visited[index] = true;
        return dfs(nums, index - nums[index], visited) || dfs(nums, index + nums[index], visited);
    }


}
