package org.example.week11;

public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;

            if(nums[start] < nums[mid]){
                if(target < nums[start] || target > nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[start] > nums[mid]){
                if(target < nums[mid] || target > nums[end]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else{

                start ++;
            }
        }
        return false;
    }
}
