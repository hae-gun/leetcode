package org.example.week14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] isValid = new boolean[c1.length+1][c2.length+1];

        isValid[0][0] = true;
        for (int i=1 ; i<=c1.length ; i++) isValid[i][0] = isValid[i-1][0] && c1[i-1] == c3[i-1];
        for (int i=1 ; i<=c2.length ; i++) isValid[0][i] = isValid[0][i-1] && c2[i-1] == c3[i-1];

        for (int i=1 ; i<=c1.length ; i++)
            for (int j=1 ; j<=c2.length ; j++)
                isValid[i][j] = (isValid[i - 1][j] && c1[i - 1] == c3[i + j - 1])
                        || (isValid[i][j - 1] && c2[j - 1] == c3[i + j - 1]);

        return isValid[c1.length][c2.length];
    }

    public boolean isInterleavePrev(String s1, String s2, String s3) {
        String ps1 = s1, ps2 = s2, ps3 = s3;
        if("".equals(s1) && "".equals(s2) && "".equals(s3)){
            return true;
        }
        boolean result = true;
//        System.out.println(String.format("#0 %s - %s - %s", s1, s2 ,s3));
        while(!"".equals(s3)){
            String prev = s3;
            for(int i=0; i<s1.length(); i++){
                if(!"".equals(s3) && s3.charAt(i) != s1.charAt(i)){
                    s3 = s3.substring(i);
                    s1 = s1.substring(i);
                    break;
                }
            }
//            System.out.println(String.format("#1 %s - %s - %s", s1, s2 ,s3));
            if(s1 != null && s1.length() == 1 && s3 != null && (s3.charAt(0) == s1.charAt(0))){
//                 System.out.println(String.format("#2-1 %s - %s - %s", s1, s2 ,s3));
                s3 = s3.substring(1);
                s1 = "";
//                 System.out.println(String.format("#2-2 %s - %s - %s", s1, s2 ,s3));
            }
            for(int i=0; i<s2.length(); i++){
                if(!"".equals(s3) && s3.charAt(i) != s2.charAt(i)){
                    s3 = s3.substring(i);
                    s2 = s2.substring(i);
                    break;
                }
            }
//            System.out.println(String.format("#3 %s - %s - %s", s1, s2 ,s3));
            if(s2 != null && s2.length() == 1 && !"".equals(s3) && (s3.charAt(0) == s2.charAt(0))){
//                System.out.println(String.format("#4-1 %s - %s - %s", s1, s2 ,s3));
                s3 = s3.substring(1);
                s2 = "";
//                System.out.println(String.format("#4-2 %s - %s - %s", s1, s2 ,s3));
            }
//            System.out.println("prev : "+prev);
//            System.out.println("s3 : "+s3);
            if(prev.equals(s3)){
                result = false;
            }
        }
        if(result) return result;
        if(!"".equals(s1) || !"".equals(s2) || !"".equals(s3)){
            s1 = ps1;
            s2 = ps2;
            s3 = ps3;

            while(!"".equals(s3)){
                String prev = s3;

                for(int i=0; i<s2.length(); i++){
                    if(!"".equals(s3) && s3.charAt(i) != s2.charAt(i)){
                        s3 = s3.substring(i);
                        s2 = s2.substring(i);
                        break;
                    }
                }
                System.out.println(String.format("#3 %s - %s - %s", s1, s2 ,s3));
                if(s2 != null && s2.length() == 1 && !"".equals(s3) && (s3.charAt(0) == s2.charAt(0))){
                    System.out.println(String.format("#4-1 %s - %s - %s", s1, s2 ,s3));
                    s3 = s3.substring(1);
                    s2 = "";
                    System.out.println(String.format("#4-2 %s - %s - %s", s1, s2 ,s3));
                }
                for(int i=0; i<s1.length(); i++){
                    if(!"".equals(s3) && s3.charAt(i) != s1.charAt(i)){
                        s3 = s3.substring(i);
                        s1 = s1.substring(i);
                        break;
                    }
                }
                System.out.println(String.format("#1 %s - %s - %s", s1, s2 ,s3));
                if(s1 != null && s1.length() == 1 && s3 != null && (s3.charAt(0) == s1.charAt(0))){
                     System.out.println(String.format("#2-1 %s - %s - %s", s1, s2 ,s3));
                    s3 = s3.substring(1);
                    s1 = "";
                     System.out.println(String.format("#2-2 %s - %s - %s", s1, s2 ,s3));
                }
                System.out.println("prev : "+prev);
                System.out.println("s3 : "+s3);
                if(prev.equals(s3)){
                    return false;
                }
            }
            if(!"".equals(s1) || !"".equals(s2) || !"".equals(s3)){
                return false;
            }
        }
        return true;
    }
}
