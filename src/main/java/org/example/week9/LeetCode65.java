package org.example.week9;

import java.math.BigDecimal;

public class LeetCode65 {
    public boolean isNumber(String s) {
        try{
            BigDecimal bigDecimal = new BigDecimal(s);
        }catch(NumberFormatException e){
            if(!eCountIsOnlyOne(s)){
                return false;
            }
            String[] es = s.split("e");
            if(es != null && es.length == 2){
                return isNumber(es[0]) && isSplitNumIsLong(es[1]);
            }
            return false;
        }
        return true;
    }

    private boolean isSplitNumIsLong(String s){
        try{
            Long.valueOf(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean eCountIsOnlyOne(String s){
        int cnt = 0;
        if(!s.contains("e")){
            return false;
        }
        for(char c : s.toCharArray()){
            if(c == 'e') cnt ++;
        }
        return cnt == 1;
    }
}
