package org.example.week3;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int result = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[i] > target){
                return i;
            }
        }
        return result;
    }
}
