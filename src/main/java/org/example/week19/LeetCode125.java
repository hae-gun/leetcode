package org.example.week19;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c :  s.toCharArray()){
            if((c >= 'a' && c <='z' )|| (c >='A' && c <= 'Z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }

        if("".equals(sb.toString())){
            return true;
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();

        return s1.equalsIgnoreCase(s2);
    }
}
