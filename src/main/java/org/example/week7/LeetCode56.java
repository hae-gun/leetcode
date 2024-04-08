package org.example.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            int[] cur = intervals[i];

            if (cur[0] > prev[1]) {
                result.add(prev);
                prev = cur;
                continue;
            }

            if (cur[1] > prev[1]) {
                prev[1] = cur[1];
            }
        }

        result.add(prev);

        int[][] resultArr = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
