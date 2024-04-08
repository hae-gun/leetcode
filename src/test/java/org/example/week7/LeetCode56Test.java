package org.example.week7;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeetCode56Test {
    LeetCode56 solution = new LeetCode56();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[1,3],[2,6],[8,10],[15,18]]:[[1,6],[8,10],[15,18]]" , "[[1,4],[4,5]]:[[1,5]]"}, delimiter = ':')
    void test(String input, String resultStr){
        int[][] merges = solution.merge(Main.make2DArray(input));
        int[][] result = Main.make2DArray(resultStr);
        for (int i = 0; i < merges.length; i++) {
            int[] merge = merges[i];
            assertThat(merge).containsExactly(result[i]);
        }
    }
}
