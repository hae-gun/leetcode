package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "[[1,2,3].[8,9,4].[7,6,5]]";
        String[] s2 = {".Q..","...Q","Q...","..Q."};
        String[] s3 = {"..Q.","Q...","...Q",".Q.."};

//        System.out.println(Arrays.toString(s2));
//        System.out.println(Arrays.toString(s3));

         showMap(make2DArray(s));
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

}