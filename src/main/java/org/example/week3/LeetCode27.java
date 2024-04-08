package org.example.week3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == val) {
                continue;
            }
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }
}
