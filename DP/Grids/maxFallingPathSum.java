package DP.Grids;

import java.util.Arrays;

public class maxFallingPathSum {

    //Recursion
    public static int maxSum(int[][] grid, int n, int i, int j) {

        if (j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }

        if (i == n - 1) {
            return grid[i][j];
        }

        int down = maxSum(grid, n, i + 1, j);
        int downLeft = maxSum(grid, n, i + 1, j - 1);
        int downRight = maxSum(grid, n, i + 1, j + 1);

        return grid[i][j] + Math.max(down, Math.max(downLeft, downRight));

    }

    //Memoization
    public static int memoization(int[][] grid) {

        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = Integer.MIN_VALUE;

        for (int col = 0; col < n; col++) {
            ans = Math.max(ans, solve(grid, dp, n, 0, col));
        }
        return ans;
    }

    public static int solve(int[][] grid, int[][] dp, int n, int i, int j) {

        if (j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }

        if (i == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = maxSum(grid, n, i + 1, j);
        int downLeft = maxSum(grid, n, i + 1, j - 1);
        int downRight = maxSum(grid, n, i + 1, j + 1);

        dp[i][j] = grid[i][j] + Math.max(down, Math.max(downLeft, downRight));

        return dp[i][j];
    }

    //Tabulation
    public static int tabulation(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = grid[0][col];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int up = grid[i][j] + dp[i - 1][j];
                int upL = grid[i][j];
                if (j > 0) {
                    upL += dp[i - 1][j - 1];
                }
                int upR = grid[i][j];
                if (j < n - 1) {
                    upR += dp[i - 1][j + 1];
                }
                dp[i][j] = Math.max(up, Math.max(upL, upR));
            }
        }
        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[n - 1][j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{8, 2, 3}, {8, 2, 3}, {8, 2, 3}};

        int n = grid.length;
        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, maxSum(grid, n, 0, j));
        }

        System.out.println(ans);

        System.out.println(memoization(grid));

        System.out.println(tabulation(grid));
    }
}
