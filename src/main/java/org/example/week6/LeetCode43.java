package org.example.week6;

public class LeetCode43 {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int int_num1 = Integer.valueOf(num1.charAt(i) - '0');
                int int_num2 = Integer.valueOf(num2.charAt(j) - '0');
                result[i + j + 1] += int_num1 *  int_num2;
            }
        }
        for(int i = result.length-1; i> 0;i--){
            result[i - 1] += result[i]/10;
            result[i] %= 10;
        }
        StringBuilder sol = new StringBuilder("");
        boolean start_chk = false;
        for(int i = 0; i < result.length; i++){
            if(result[i] != 0 && !start_chk){
                start_chk = true;
            }

            if(start_chk)sol.append(result[i]);
        }
        if(sol.length() == 0){
            return "0";
        }
        return sol.toString();
    }
}
