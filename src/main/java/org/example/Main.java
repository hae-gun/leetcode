package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String s = "[[1,2,3].[8,9,4].[7,6,5]]";
//        String[] s2 = {".Q..","...Q","Q...","..Q."};
//        String[] s3 = {"..Q.","Q...","...Q",".Q.."};
//        // LeetCode65 input
//        String[] s4 = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
//        String[] s5 = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//        System.out.println(Arrays.toString(s2));
//        System.out.println(Arrays.toString(s3));
//        System.out.println(Arrays.toString(makeParameter(s4, true)));
//        System.out.println(Arrays.toString(makeParameter(s5, false)));
        // Leetcode68
//        String[] s1 = {"This", "is", "an", "example", "of", "text", "justification."};
//        int r1_1 = 16;
//        String[] r1 = {"This    is    an", "example  of text", "justification.  "};
//        String[] s2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
//        int r2_1 = 16;
//        String[] r2 = {"What   must   be", "acknowledgment  ", "shall be        "};
//        String[] s3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
//        int r3_1 = 20;
//        String[] r3 = {"Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  "};
//
//        System.out.println(String.format("%s:%d:%s", makeStrsConcat(s1), r1_1, makeStrsConcat(r1)));
//        System.out.println(String.format("%s:%d:%s", makeStrsConcat(s2), r2_1, makeStrsConcat(r2)));
//        System.out.println(String.format("%s:%d:%s", makeStrsConcat(s3), r3_1, makeStrsConcat(r3)));
        //Input: matrix = [[1,1,1].[1,0,1].[1,1,1]]
        //Output: [[1,0,1].[0,0,0].[1,0,1]]
        //Input: matrix = [[0,1,2,0].[3,4,5,2].[1,3,1,5]]
        //Output: [[0,0,0,0].[0,4,5,0].[0,3,1,0]]

        String s1 = "[[1,1,1].[1,0,1].[1,1,1]]";
        String r1 = "[[1,0,1].[0,0,0].[1,0,1]]";
        String s2 = "[[0,1,2,0].[3,4,5,2].[1,3,1,5]]";
        String r2 = "[[0,0,0,0].[0,4,5,0].[0,3,1,0]]";

        System.out.println(s1);
        System.out.println(r1);
        System.out.println(s2);
        System.out.println(r2);

//
    }

    public static void showMap(int[][] map) {
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static int[][] make2DArray(String arrStr) {
        // [[1,3],[2,6],[8,10],[15,18]]
        arrStr = arrStr.replaceAll("\\],\\[", ".").replaceAll("\\[", "").replaceAll("\\]", "");

        return Arrays.stream(arrStr.split("\\.")).map(v -> Arrays.stream(v.split(","))
                .mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
    }

    public static String[] makeParameter(String[] s, boolean result) {
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            s[i] = String.format("\"%s:%b\"", s[i], result);
        }
        return s;
    }

    public static String makeStrsConcat(String[] words) {
        return String.join(",", words);
    }

    public static void show2DArray(Object[][] arr){
        for(Object[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }

}