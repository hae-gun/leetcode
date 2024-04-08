package org.example.week10;

import java.util.ArrayList;
import java.util.List;

public class LeetCode70 {

    public int climbStairs(int n) {
        int[] result = new int[n+1];
        if(n == 1) return 1;
        if(n == 2) return 2;
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;

        for(int i=3; i<=n; i++){
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }


}
