package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "[[1,2,3].[8,9,4].[7,6,5]]";
        String[] s2 = {".Q..","...Q","Q...","..Q."};
        String[] s3 = {"..Q.","Q...","...Q",".Q.."};
        // LeetCode65 input
        String[] s4 = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] s5 = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//        System.out.println(Arrays.toString(s2));
//        System.out.println(Arrays.toString(s3));
        System.out.println(Arrays.toString(makeParameter(s4, true)));
        System.out.println(Arrays.toString(makeParameter(s5, false)));

    }
    public static void showMap(int[][] map) {
        for(int[] m : map){
            System.out.println(Arrays.toString(m));
        }
    }
    
    public static int[][] make2DArray(String arrStr){
        // [[1,3],[2,6],[8,10],[15,18]]
        arrStr = arrStr.replaceAll("\\],\\[", ".")
                        .replaceAll("\\[","")
                        .replaceAll("\\]","");

        return Arrays.stream(arrStr.split("\\."))
                .map(v -> Arrays.stream(v.split(",")).mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);
    }
    
    public static String[] makeParameter(String[] s , boolean result){
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            s[i] = String.format("\"%s:%b\"", s[i], result);
        }
        return s;
    }
    

}