package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String
        String s1 = "[[1,1,1].[1,0,1].[1,1,1]]";
        String r1 = "[[1,0,1].[0,0,0].[1,0,1]]";
        String s2 = "[[0,1,2,0].[3,4,5,2].[1,3,1,5]]";
        String r2 = "[[0,0,0,0].[0,4,5,0].[0,3,1,0]]";

        System.out.println(s1);
        System.out.println(r1);
        System.out.println(s2);
        System.out.println(r2);

        String ss = "[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]";
        int[][] a = make2DArray(ss);
        System.out.println(a);
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