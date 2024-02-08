package org.example.week10;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode72Test {
    LeetCode72 solution = new LeetCode72();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"horse:ros:3" ,"intention:execution:5"},delimiter = ':')
    void test(String word1, String word2, int result){
        assertThat(solution.minDistance(word1, word2)).isEqualTo(result);
    }
}
