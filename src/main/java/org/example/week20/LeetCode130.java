package org.example.week20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode130 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        // surrond number -> change
        if(board == null) return;

        boolean[][] changeVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar == 'O'){
                    boolean isSurrounded = checkMap(i, j, board);
                    if(isSurrounded){
                        spreadX(i,j,board, changeVisited);
                    }
                }
            }
        }
    }

    private boolean checkMap(int i, int j, char[][] board) {
        Queue<int[]> que = new LinkedList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];

        que.add(new int[]{i,j});

        while(!que.isEmpty()){
            int[] position = que.poll();
            if(!visited[position[0]][position[1]]){
                visited[position[0]][position[1]] = true;
                for(int idx=0;idx<4; idx++){
                    int[] ds = dirs[idx];
                    int nx = position[0]+ds[0];
                    int ny = position[1]+ds[1];
                    if(nx < board.length && nx >= 0 && ny < board[0].length && ny >=0){
                        if(!visited[nx][ny] && board[nx][ny] == 'O'){
                            que.add(new int[]{nx, ny});
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void spreadX(int i, int j, char[][] board, boolean[][] changeVisited) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        que.add(new int[]{i,j});

        while(!que.isEmpty()){
            int[] position = que.poll();
            int x = position[0];
            int y = position[1];
            if(!visited[x][y]){
                visited[x][y] = true;
                changeVisited[x][y] = true;
                board[x][y] = 'X';
                for(int idx=0;idx<4; idx++){
                    int[] ds = dirs[idx];
                    int nx = x+ds[0];
                    int ny = y+ds[1];
                    if(nx < board.length && nx >= 0 && ny < board[0].length && ny >=0 && !visited[nx][ny] && board[nx][ny] == 'O'){
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
