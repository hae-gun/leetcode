package org.example.week5;

import java.util.Arrays;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }


    public boolean backtrack(char[][] board, int idx) {
        if(idx==81) return true;
        int row = idx / 9;
        int col = idx % 9;
        char cur = board[row][col];
        // 숫자가 존재
        if(cur != '.') {
            return backtrack(board, idx+1);
        }else {	// 빈공간
            for(int i=1; i<=9; i++) {
                board[row][col] = Integer.toString(i).charAt(0);
                //System.out.println(board[row][col]);
                if(isValidSudoku(board)) {
                    boolean b = backtrack(board, idx + 1);
                    if(b) return b;
                }
            }
            board[row][col] = '.';
            return false;
        }
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] b = new boolean[9];
        //룰의 종류, 가로/세로/섭그리드
        for(int i=0; i<3; i++) {
            //한줄의 규칙
            for(int j=0; j<9; j++) {
                Arrays.fill(b, false);
                for(int k=0; k<9; k++) {
                    char cur= '.';
                    if(i == 0) {
                        //가로
                        cur=board[j][k];
                    }else if(i == 1) {
                        //세로
                        cur=board[k][j];
                    }else {
                        //섭그리드
                        cur = board[j/3*3 + k/3][j%3*3 + k%3];
                    }
                    if(cur=='.') continue;
                    int val = Character.getNumericValue(cur);
                    //System.out.println("k-> "+k+"    cur->"+cur+"   val::::"+val);
                    if(b[val-1]) return false;
                    b[val-1] = true;
                }
            }
        }
        return true;
    }
}
