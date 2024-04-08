package org.example.week10;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode70Test {
    LeetCode70 solution = new LeetCode70();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2:2","3:3","4:5"},delimiter = ':')
    void test(int input, int result){
        assertThat(solution.climbStairs(input)).isEqualTo(result);
    }
}
