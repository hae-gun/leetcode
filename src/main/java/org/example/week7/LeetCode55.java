package org.example.week7;

import java.util.Arrays;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int curIndex = nums.length - 1; curIndex >= 0; curIndex--) {
            if (curIndex + nums[curIndex] >= lastIndex) {
                lastIndex = curIndex;
            }
        }
        return lastIndex == 0;
    }
}