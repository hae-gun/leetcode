package org.example.week9;

import java.util.Arrays;

public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i=1; i<m; i++){
            int prev = dp[i-1][0];
            dp[i][0] = prev + grid[i][0];
        }

        for(int i=1; i<n; i++){
            int prev = dp[0][i-1];
            dp[0][i] = prev + grid[0][i];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Integer.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
