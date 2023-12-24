package org.example.week1;

import java.math.BigDecimal;

public class Leetcode7 {
    public int reverse(int x) {
        BigDecimal bd = new BigDecimal(x);

        String result = "";
        System.out.println(x);
        StringBuilder sb = new StringBuilder();
        if(bd.doubleValue() < 0){
            bd = bd.negate();
            sb.append(bd.toPlainString());
            sb.append("-");
        }else{
            sb.append(bd.toPlainString());
        }
        result = sb.reverse().toString();
        System.out.println(result);
        try{
            return Integer.valueOf(result);
        } catch(Exception e) {
            return 0;
        }
    }
}
