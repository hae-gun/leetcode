package org.example.day1;

import java.util.ArrayList;
import java.util.List;

public class LeetCode12 {
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public String intToRoman(int num) {
        String nums = String.valueOf(num);
        List<String> list = new ArrayList<>();
        for(int i=0; i<nums.length(); i++){
            int n = Integer.valueOf(""+nums.charAt(i));
            n *= Math.pow(10, nums.length()-1-i);
            list.add(String.valueOf(n));
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(convertToItalyNun(s));
        }
        return sb.toString();
    }
    String[] wordsTen = new String[]{"I", "X", "C", "M"};
    String[] wordsFive = new String[]{"V", "L", "D"};
    public String convertToItalyNun(String numStr){

        int firstWord = Integer.valueOf(numStr.substring(0, 1));

        int n = numStr.length() -1; // 10^n

        if (firstWord == 9){
            return wordsTen[n] + wordsTen[n+1];
        }

        if(firstWord == 4){
            return wordsTen[n] + wordsFive[n];
        }

        if(firstWord == 5){
            return wordsFive[n];
        }

        if(firstWord > 5){
            StringBuilder sb = new StringBuilder();
            for(int i=0 ;i<Integer.valueOf(firstWord)-5; i++){
                sb.append(wordsTen[n]);
            }
            return  wordsFive[n] + sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<Integer.valueOf(firstWord); i++){
            sb.append(wordsTen[n]);
        }
        return sb.toString();
    }
}
