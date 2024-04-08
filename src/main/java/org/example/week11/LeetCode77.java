package org.example.week11;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int arr[] = new int[n];
        boolean visited[]= new boolean[n];

        comb(result, visited, 0, n, k);

        return result;
    }

    static void comb(List<List<Integer>> result, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]){
                    list.add(i+1);
                }
            }
            result.add(list);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(result, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(result, visited, depth + 1, n, r);
    }
}
