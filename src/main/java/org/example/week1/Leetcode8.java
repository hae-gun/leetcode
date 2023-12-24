package org.example.week1;

import java.math.BigDecimal;

public class Leetcode8 {
    private final double MAX = Integer.MAX_VALUE * 1.0;
    private final double MIN = Integer.MIN_VALUE * 1.0;
    public int myAtoi(String s) {
        boolean meetNumberFront = false;
        int idx= 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!meetNumberFront && (c == ' ')){
                continue;
            }
            if(!meetNumberFront && (c == '-' || c == '+')){
                sb.append(c);
                meetNumberFront = true;
                continue;
            }
            if(!meetNumberFront){
                meetNumberFront = true;
            }
            if(c < '0' || c > '9'){
                break;
            }
            sb.append(c);
        }
        try{
            BigDecimal bd = new BigDecimal(sb.toString());
            if(bd.doubleValue() > MAX){
                return (int)MAX;
            }
            if(bd.doubleValue() < MIN){
                return (int)MIN;
            }
            return (int)bd.doubleValue();
        }catch(Exception e){

        }
        return 0;
    }
}
