package org.example.week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode79 {

    private boolean bt(char[][] board, int y, int x, String word, int idx, boolean[][] visited1) {

        if (idx == word.length()) { //문자열의 모든 단어를 찾은 경우
            return true;
        }

        int i = board.length;
        int j = board[0].length;
        if (x < 0 || x >= j) { // 조건이 맞지 않는 경우
            return false;
        }
        if (y < 0 || y >= i) { // 조건이 맞지 않는 경우
            return false;
        }
        if (visited1[y][x]) { // 조건이 맞지 않는 경우
            return false;
        }

        if (word.charAt(idx) == board[y][x]) {
            visited1[y][x] = true;
            // 다음 노드들이 조건 맞는지 확인
            boolean rst = bt(board, y - 1, x, word, idx + 1, visited1) ||
                    bt(board, y + 1, x, word, idx + 1, visited1)||
                    bt(board, y, x - 1, word, idx + 1, visited1) ||
                    bt(board, y, x + 1, word, idx + 1, visited1);

            if (!rst) {
                visited1[y][x] = false;
            } else {
                return true;
            }
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {

        char start = word.charAt(0);
        boolean[][] visited1 = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == start) {
                    if (bt(board, i, j, word, 0, visited1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean exist_wrong(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        List<int[]> startPosition =new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            char[] line = board[i];
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                if(word.length() == 1 && c == word.charAt(0)){
                    return true;
                }
                if(c == word.charAt(0)) startPosition.add(new int[]{i, j, 1});
            }
        }

        for(int[] position : startPosition){
            if(findWord(board, new boolean[board.length][board[0].length], position, word)){
                return true;
            }
        }
        return false;
    }
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean findWord(char[][] board, boolean[][] visited, int[] position, String word) {
        Stack<int[]> stack = new Stack<>();

        int h = board.length;
        int w = board[0].length;
        stack.add(position);
        System.out.println("find word is " + word);
        visited[position[0]][position[1]] = true;
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            int py = pos[0];
            int px = pos[1];
            System.out.println(String.format("start at %d %d : %c", pos[0], pos[1], word.charAt(pos[2]-1)));
            for(int dir=0; dir<4; dir++){
                int ny = py + dirs[dir][0];
                int nx = px + dirs[dir][1];
                System.out.println(ny + "," + nx);
                if(ny >= 0 && ny <board.length && nx >=0 && nx < board[0].length &&
                        !visited[ny][nx]){
                    if(board[ny][nx] == word.charAt(pos[2])){
                        visited[ny][nx]  = true;
                        if(pos[2] == word.length()-1){
                            return true;
                        }
                        stack.push(new int[]{ny, nx, pos[2]+1});
                    }else{
                        stack.push(pos);
                    }
                    System.out.println(ny + "," + nx + " is " + board[ny][nx]);
                }
            }
        }
        return false;
    }
}
