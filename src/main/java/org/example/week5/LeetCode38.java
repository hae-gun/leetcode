package org.example.week5;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode38 {

    public String countAndSay(int n) {
        String result = "1";
        for(int i=1; i<=n; i++){
            result = recursive(i, result);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode38 code = new LeetCode38();
        for(int i=1 ;i <= 5; i++){
//            System.out.println(code.countAndSay(i));
        }

    }

    public String recursive (int n, String input){
        if(n == 1) return "1";

        String[] words = input.split("");
        Stack<String> stack = new Stack<>();

        stack.add(words[0]);
        int cnt = 1;
        String result = "";
        for(int i=1 ; i<words.length; i++){
            if(stack.peek().equals(words[i])){
                cnt++;
            }else{
                result += cnt + stack.pop();
                stack.add(words[i]);
                cnt = 1;
            }
        }
        if(!stack.isEmpty()){
            result += cnt + stack.pop();
        }
        return result;
    }

}
