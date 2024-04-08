package org.example.week11;

import java.util.HashMap;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        // 찾아야 하는 알파벳 총 수
        for(char c : t_arr){
            arr[c] ++;
        }
        // pointer 정의 slide window 사용
        int left = 0, right = 0;
        // minLen 정의
        int minLen = Integer.MAX_VALUE;
        // ans
        String ans = "";
        int counter = 0;
        // min window 찾기

        while(right < s_arr.length){
            char curChar = s_arr[right];
            if(--arr[curChar] >= 0){
                counter++;
            }
            while(counter == t_arr.length){
                int curWindow = right - left + 1;
                if(curWindow < minLen){
                    minLen = curWindow;
                    ans = s.substring(left, right+1);
                }
                char leftChar = s_arr[left];
                if(++arr[leftChar]>0){
                    counter--;
                }
                left ++;
            }
            right++;
        }
        return ans;
    }
}
