package org.example.week6;

import java.util.Arrays;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        boolean[] bs = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums.length < nums[i] || nums[i] <= 0){
                nums[i] = -1;
                continue;
            }
            bs[nums[i]-1] = true;
        }

        for(int i=0 ; i < bs.length; i++){
            boolean b = bs[i];
            if(!b){
                result = i+1;
                break;
            }
        }

        boolean[] allTrue = new boolean[bs.length];
        Arrays.fill(allTrue, true);

        if(Arrays.equals(allTrue, bs)){
            return bs.length+1;
        }

        return result;
    }
}
