package org.example.week8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode59 {
    private int[][] dirs = {{0,1}, {-1,0},{0,-1},{1,0}};
    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];

        int dir = 0;
        int cx = 0;
        int cy = 0;

        map[cx][cy] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(map[cx][cy]);
        while(!queue.isEmpty()){
//            showMap(map);
            int curNum = queue.poll();
            for(int i=0; i < 4; i++){
                dir = (dir + i) % 4;
                int nx = cx + dirs[dir][0];
                int ny = cy + dirs[dir][1];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[nx][ny] != 0){
                    continue;
                }

                map[nx][ny] = curNum+1;
                queue.add(map[nx][ny]);
                cx = nx;
                cy = ny;
                break;
            }
        }
        return map;
    }

    private void showMap(int[][] map) {
        for(int[] m : map){
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        LeetCode59 solution  = new LeetCode59();
        solution.generateMatrix(3);
    }
}
