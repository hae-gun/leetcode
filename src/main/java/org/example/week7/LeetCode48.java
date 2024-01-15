package org.example.week7;

import java.util.Arrays;

public class LeetCode48 {
    public void rotate(int[][] matrix) {

        int n = matrix[0].length;
        int rot = n%2==0 ? n/2 : n/2+1;
        int cnt = n-1;

        for(int i = 0; i < rot; i++){
            for(int j = 0; j < cnt; j++){

                int temp1 = matrix[i][j+i];
                matrix[i][j+i] = matrix[n-1-j-i][i];
                matrix[n-1-j-i][i] = matrix[n-1-i][n-1-j-i];
                matrix[n-1-i][n-1-j-i] = matrix[j+i][n-1-i];
                matrix[j+i][n-1-i] = temp1;
            }
            cnt -= 2;
        }
    }
}
