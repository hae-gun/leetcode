package org.example.week8;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode52Test {
    LeetCode52 solution = new LeetCode52();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"4:2", "1:1"}, delimiter = ':')
    void test(int input, int result){
        assertThat(solution.totalNQueens(input)).isEqualTo(result);
    }
}
