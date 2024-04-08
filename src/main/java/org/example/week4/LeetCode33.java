package org.example.week4;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        // 이진탐색
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            // 'mid' 값이 'left' 값보다 크거나 같은 경우,
            // 즉, 왼쪽 절반이 정렬되어 있는 경우입니다.
            if (nums[mid] >= nums[left]) {
                // 타겟이 'left'와 'mid' 사이에 있는 경우,
                // 'right'를 'mid'로 옮깁니다.
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                    // 타겟이 'mid'보다 큰 경우,
                    // 탐색 범위를 오른쪽 절반으로 옮깁니다.
                } else {
                    left = mid + 1;
                }
                // 오른쪽 절반이 정렬되어 있는 경우입니다.
                continue;
            }
            // 타겟이 'mid'와 'right' 사이에 있는 경우,
            // 'left'를 'mid'로 옮깁니다.
            if (target <= nums[right] && target > nums[mid]) {
                left = mid;
                // 타겟이 'mid'보다 작은 경우,
                // 탐색 범위를 왼쪽 절반으로 옮깁니다.
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
