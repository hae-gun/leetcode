package org.example.week7;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {

        int height = matrix.length;
        int width = matrix[0].length;

        boolean [][] visited = new boolean[height][width];

        List<Integer> result = new ArrayList<>();


        int curDir = 0;
        int dx = 0;
        int dy = 0;


        while(true){
            System.out.println(result);
            if(!visited[dy][dx]){
                visited[dy][dx] = true;
                result.add(matrix[dy][dx]);
            }
            boolean isCanGo = false;
            for(int i=0; i<4; i++){
                int ny = dy + dirs[curDir][0];
                int nx = dx + dirs[curDir][1];

                if(nx >= 0 && nx < width && ny >= 0 && ny < height && !visited[ny][nx]){
                    dx = nx;
                    dy = ny;
                    isCanGo = true;
                    break;
                }
                curDir = (curDir + 1) % 4;
            }
            if(!isCanGo) break;
        }
        return  result;
    }

}
