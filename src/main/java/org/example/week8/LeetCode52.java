package org.example.week8;

import java.util.ArrayList;
import java.util.List;

public class LeetCode52 {
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        return dfs(new int[n], 0);
    }

    private int dfs(int[] columns, int row) {
        if (row == columns.length) return 1;
        int count = 0;
        for (int col = 0; col < columns.length; col++) {
            if (validate(columns, row, col)) {
                columns[row] = col; // place queen
                count += dfs(columns, row + 1);
            }
        }
        return count;
    }

    // Validate the prior row, colomn & diagnal
    private boolean validate(int[] columns, int row, int col) {
        for (int newRow = 0; newRow < row; newRow++) {
            int newCol = columns[newRow];
            if (col == newCol || Math.abs(row - newRow) == Math.abs(col - newCol)) {
                return false;
            }
        }
        return true;
    }
}
