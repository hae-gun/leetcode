package org.example.week7;

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = nums.length, max = dp[0];
        for(int i=1; i<len; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
