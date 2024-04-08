package org.example.week12;

import org.example.week2.ListNode;

import java.util.Stack;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        if(heights.length ==1){
            return heights[0];
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>(); // index stack
        stack.add(0);
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            if (curr >= heights[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                    int temp = heights[stack.pop()];
                    if (stack.isEmpty()) {
                        max = Math.max(max, temp * i);
                    } else {
                        max = Math.max(max, temp * (i - stack.peek() - 1));
                    }
                }
                stack.add(i);
            }
        }
        if(!stack.isEmpty()){
            int i = heights.length;
            while (!stack.isEmpty()) {
                int temp = heights[stack.pop()];
                if (stack.isEmpty()) {
                    max = Math.max(max, temp * i);
                } else {
                    max = Math.max(max, temp * (i - stack.peek() - 1));
                }
            }
        }
        return max;
    }
}
