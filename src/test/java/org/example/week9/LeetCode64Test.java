package org.example.week9;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode64Test {
    LeetCode64 solution = new LeetCode64();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[1,3,1],[1,5,1],[4,2,1]]:7","[[1,2,3],[4,5,6]]:12"},delimiter = ':')
    void test(String mapStr, int result){

        int[][] map = Arrays.stream(mapStr.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").split("\\],\\["))
                .map(v -> Arrays.stream(v.split("\\,")).mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);

        assertThat(solution.minPathSum(map)).isEqualTo(result);
    }
}
