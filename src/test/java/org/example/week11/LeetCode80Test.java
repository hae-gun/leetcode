package org.example.week11;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode80Test {
    LeetCode80 solution = new LeetCode80();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,1,1,2,3:5","0,0,1,1,1,1,2,3,3:7"},delimiter = ':')
    void test(String arrStr, int result) {
        int[] arr = Arrays.stream(arrStr.split(",")).mapToInt(Integer::valueOf).toArray();
        assertThat(solution.removeDuplicates(arr)).isEqualTo(result);
    }
}