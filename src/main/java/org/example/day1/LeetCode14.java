package org.example.day1;

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String s = "";
        for(int i=0; i<strs[0].length(); i++){
            String s1 = strs[0].substring(0,i+1);
            for(int j=1; j<strs.length; j++){
                if(strs[j].startsWith(s1)){
                    continue;
                }
                return s;
            }
            s = s1;
        }
        return s;
    }
}
