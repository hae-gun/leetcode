package org.example.week6;

import java.util.Arrays;

public class LeetCode45 {
    public int jump(int[] nums) {
        int[] temp = new int[nums.length];

        for(int i=0 ; i<nums.length; i++){
            for(int j=1; j < nums.length; j++){
                if(j >= nums[i] + 1) continue;
                if(i+j >= nums.length) continue;
                if(temp[i+j] == 0) temp[i+j] = temp[i]+1;
            }
        }
        return temp[temp.length-1];
    }
}
