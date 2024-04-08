package org.example.week6;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        backtracking(rst, nums, new ArrayList<Integer>());
        return rst;
    }

    public void backtracking(List<List<Integer>> rst, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) { // 조건이 만족 하는지 확인
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i : nums) { // 더 탐색할 하위 노드 탐색
            if (!list.contains(i)) {
                list.add(i);
                backtracking(rst, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
