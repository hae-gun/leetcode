package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode10Test {
    LeetCode10 solution = new LeetCode10();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"aa:a:false", "aa:a*:true", "ab:.*:true"}, delimiter = ':')
    void test(String s, String p, boolean result) {
        assertThat(solution.isMatch(s, p)).isEqualTo(result);
    }
}