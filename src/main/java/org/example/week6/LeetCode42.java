package org.example.week6;

import java.util.Arrays;

public class LeetCode42 {
    public int trap(int[] height) {
        int[] toRight = new int[height.length];
        int[] toLeft = new int[height.length];

        int minLeft=0;
        int minRight=0;
        for(int leftIdx=0; leftIdx < height.length; leftIdx++){
            int rightIdx = height.length-1-leftIdx;
            int left = height[leftIdx];
            int right = height[rightIdx];
            minLeft = Math.max(minLeft, left);
            minRight = Math.max(minRight, right);
            toRight[leftIdx] = minLeft;
            toLeft[rightIdx] = minRight;
        }

        for(int i=0 ; i<height.length; i++){
            height[i] = Math.min(toLeft[i], toRight[i]) - height[i];
        }
        return Arrays.stream(height).reduce(Integer::sum).orElseGet(() -> 0);
    }
}
