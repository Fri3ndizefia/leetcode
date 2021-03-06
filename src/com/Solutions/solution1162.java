package com.Solutions;

import java.util.ArrayDeque;
import java.util.Queue;

public class solution1162 {
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        // put ALL island elements into queue
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int[][] moves = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };
        int distance = -1; // layer that traversal
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] move : moves) {
                    int r2 = r + move[0];
                    int c2 = c + move[1];
                    if (inArea(grid, r2, c2) && grid[r2][c2] == 0) {
                        grid[r2][c2] = 2;
                        queue.add(new int[]{r2, c2});
                    }
                }
            }
        }
        return distance;
    }

    boolean inArea(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length
                && 0 <= j && j < grid[0].length;
    }
}
