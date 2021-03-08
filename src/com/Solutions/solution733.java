package com.Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class solution733 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    // BFS
    // 一层一层的遍历到结束


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }

        int n = image.length, m = image[0].length;
        // n 索引数组的第一个
        // m 索引数组的第二个
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; ++i) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }


    // DFS
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;
    }

        public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; ++i) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }
}
