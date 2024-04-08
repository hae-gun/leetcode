package org.example.week4;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode32Test {
    LeetCode32 solution = new LeetCode32();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"(():2", ")()()):4",  "\"\":0"}, delimiter = ':')
    void test(String str, String ansStr){
        int expectAns = Integer.valueOf(ansStr);
        int result = solution.longestValidParentheses(str);
        assertThat(result).isEqualTo(expectAns);

    }
}