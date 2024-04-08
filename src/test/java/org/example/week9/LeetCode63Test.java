package org.example.week9;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode63Test {
    LeetCode63 solution = new LeetCode63();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[0,0,0],[0,1,0],[0,0,0]]:2","[[0,1],[0,0]]:1", "[[0,0],[1,1],[0,0]]:0"},delimiter = ':')
    void test(String mapStr, int result){

        int[][] map = Arrays.stream(mapStr.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").split("\\],\\["))
                .map(v -> Arrays.stream(v.split("\\,")).mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);

        assertThat(solution.uniquePathsWithObstacles(map)).isEqualTo(result);
    }
}
