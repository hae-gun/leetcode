package org.example.week9;

import java.util.Arrays;

public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] a = new int[m][n];
        a[0][0]=0;

        // fill first col with 1 but break when you hit obstacle
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            a[i][0] = 1;
        }

        // fill first row with 1 but break when you hit obstacle
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            a[0][i] = 1;

        }

        // use dp
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){continue;}
                a[i][j] += a[i][j-1] + a[i-1][j];
            }
        }

        return a[m-1][n-1];
    }

}
