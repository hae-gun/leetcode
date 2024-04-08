package org.example.week12;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null) return 0;
        if(matrix.length == 1 && matrix[0].length == 1){
            return Integer.parseInt(""+matrix[0][0]);
        }
        int[][] histogram = new int [matrix.length][matrix[0].length];

        for(int i=0; i<matrix[0].length; i++){
            histogram [0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < histogram.length; i++) {
            for (int j = 0; j < histogram[i].length; j++) {
                if(matrix[i][j] == '0') continue;
                histogram[i][j] = histogram[i-1][j] + (matrix[i][j] - '0');
            }
        }
        int max = -1;
        for (int i = 0; i < histogram.length; i++) {
            max = Math.max(max, findMaxSize(histogram[i]));
        }

        return max;
    }
    private int findMaxSize(int[] histogram) {
        int max = -1;
        for(int i=0 ;i<histogram.length; i++){
            int prev = histogram[i];
            int size = 0;
            for(int j=i; j<histogram.length; j++){
                if(prev > histogram[j]) {
                    break;
                }
                size += prev;
            }
            for(int j=i-1; j>=0; j--){
                if(prev > histogram[j]) {
                    break;
                }
                size += prev;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
