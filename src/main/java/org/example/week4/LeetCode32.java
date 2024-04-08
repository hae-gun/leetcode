package org.example.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode32 {

    private final char left = '(';
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        if("".equals(s)) return 0;

        char[] arrays = s.toCharArray();

        for (int i = 0; i < arrays.length; i++) {
            char word = arrays[i];
            if(word == left) {
                stack.add(i);
                continue;
            }
            stack.pop();
            if(stack.isEmpty()){
                stack.add(i);
            }else{
                result = Math.max(result, i - stack.peek());
            }
        }
        return result;
    }
}
