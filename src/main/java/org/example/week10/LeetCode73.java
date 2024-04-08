package org.example.week10;

import org.example.Main;

import java.util.Arrays;

public class LeetCode73 {

    int[][] dirs = {{0, 1}, {0,-1}, {1,0}, {-1,0}};

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] copyArr = new int[m][n];

        copyArray(copyArr, matrix);
        for (int i = 0; i < copyArr.length; i++) {
            for (int j = 0; j < copyArr[i].length; j++) {
                if(matrix[i][j] == 0){
                    spreadZero(copyArr, i, j);
                }
            }
        }
        copyArray(matrix, copyArr);
    }

    private static void copyArray(int[][] srcArr, int[][] tgtArr) {
        for (int i = 0; i < tgtArr.length; i++) {
            srcArr[i] = Arrays.copyOf(tgtArr[i], tgtArr[i].length);
        }
    }

    void spreadZero(int[][] arr, int px, int py){
        int dir = 0;
        for(int i=0; i<4; i++){
            int cx = px;
            int cy = py;
            cx += dirs[dir][0];
            cy += dirs[dir][1];
            while(cx >= 0 && cx < arr.length && cy >= 0 && cy < arr[0].length) {
                arr[cx][cy] = 0;
                cx += dirs[dir][0];
                cy += dirs[dir][1];
            }
            dir++;
        }
    }

}
