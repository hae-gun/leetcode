package org.example.week8;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode59Test {
    LeetCode59 solution = new LeetCode59();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"3:[[1,2,3].[8,9,4].[7,6,5]]", "1:[[1]]"}, delimiter = ':')
    void test(int input, String mapStr){

        int[][] matrix = Arrays.stream(mapStr.split("\\."))
                .map(v -> Arrays.stream(v.replaceAll("\\]", "").replaceAll("\\[", "").split(","))
                        .mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);
        int[][] result = solution.generateMatrix(input);
        for (int i = 0; i < matrix.length; i++) {
            assertThat(result[i]).containsExactly( matrix[i]);
        }
    }
}
