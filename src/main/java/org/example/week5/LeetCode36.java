package org.example.week5;

import java.util.HashSet;

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char current = board[i][j];
                if(current != '.') {
                    if(!set.add(current + "-row-" + i) ||
                            !set.add(current + "-col-" + j) ||
                            !set.add(current + "-box-" + i / 3 + "," + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
