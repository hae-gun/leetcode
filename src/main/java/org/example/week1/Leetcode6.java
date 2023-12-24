package org.example.week1;

public class Leetcode6 {
    public String convert(String s, int numRows) {
        String[] strs = new String[numRows];
        for(int i=0; i<numRows; i++){
            strs[i] = "";
        }
        if(numRows == 1){
            return s;
        }
        int index = 0;
        boolean down = true;
        for(int i=0; i<s.length(); i++){
            strs[index] += s.charAt(i);
            if(down){
                index++;
            }else{
                index--;
            }
            if(index >= numRows){
                down = !down;
                index = strs.length-2;
            }
            if(index < 0){
                down = !down;
                index = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }
}
