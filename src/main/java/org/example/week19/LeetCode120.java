package org.example.week19;

import java.util.List;
import java.util.stream.Stream;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int height = triangle.size() - 1;
        for (int i = 0; i < triangle.get(height).size(); i++) { // (1)
            total[i] = triangle.get(height).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) { // (2)
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) { // (3)
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]); // (4)
            }
        }
        return total[0];

    }
}
