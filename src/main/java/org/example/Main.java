package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "[[1,3],[2,6],[8,10],[15,18]]";

        System.out.println(Arrays.toString(make2DArray(s)));
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