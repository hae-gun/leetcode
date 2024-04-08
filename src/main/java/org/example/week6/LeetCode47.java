package org.example.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    int[] givenNums;
    boolean[] visited;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.givenNums = nums;
        this.visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(this.givenNums);
        dfs(temp);
        return this.ans;
    }

    public void dfs(List<Integer> temp) {
        if (temp.size() == this.givenNums.length) {
            this.ans.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < this.givenNums.length; i++) {
            if (i > 0 && !this.visited[i-1] && this.givenNums[i] == this.givenNums[i-1]) continue;
            if (this.visited[i]) continue;
            temp.add(this.givenNums[i]);
            visited[i] = true;
            dfs(temp);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }

}
