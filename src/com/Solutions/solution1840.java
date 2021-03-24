package com.Solutions;

/**
 * 剑指 12
 * 矩阵中的路径
 * <p>
 * 核心考察 DFS和剪枝
 */
public class solution1840 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();

        /**
         * 寻找第一个出发点（也就是第一个满足匹配点）
         * 一旦进入到了第一个出发点，就会一直递归下去，直到递归完所有的路线
         */
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        /**
         * 剪枝的条件要么是越界，要么是不等于，也就是未找到
         */
        if (i >= board.length ||
                i < 0 ||
                j >= board[0].length ||
                j < 0 ||
                board[i][j] != words[k]) {
            return false;
        }
        /**
         * 查找到了最后一个words，按理来说，已经结束。并且通过了上面的检查，也就是找完了
         */
        if (k == words.length - 1) {
            return true;
        }
        /**
         * 一旦找到一个，就标记成 0，以免重复性使用
         */
        board[i][j] = '\0';
        boolean rs =
                dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);

        /**
         * 这里将board恢复原来的值是因为
         * 如果一条路找失败了，就会返回false上去
         * 但是仅仅是这一条路失败了，不能影响其他路的递归搜索
         * 所以需要把现场还原。
         * 整体的思路就是
         * 破坏现场-dfs-还原现场
         * （运气好的话 破坏一次现场，dfs一条路，就得到答案，不再破坏第二次现场）
         */
        board[i][j] = words[k];
        return rs;
    }
}
