package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode38Test {
    LeetCode38 solution = new LeetCode38();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1:1", "4:1211"}, delimiter = ':')
    void test(int cnt, String result){
        assertThat(solution.countAndSay(cnt)).isEqualTo(result);

    }
}