package org.example.day1;

import java.util.Arrays;

public class Leetcode11 {
    public int maxArea(int[] height) {
        // int[][] dp = new int[height.length][height.length];

        int result = 0;
        int[] he = height.clone();
        Arrays.sort(he);
      /* for(int i=0; i<height.length; i++){

        }*/

        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(he));

        return result;
    }
}
