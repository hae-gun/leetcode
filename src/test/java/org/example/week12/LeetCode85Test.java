package org.example.week12;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode85Test {
    LeetCode85 solution = new LeetCode85();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"10100/10111/11111/10010:6","0:0", "1:1"},delimiter = ':')
    void test(String inputStr, int output) {
        String[] line = inputStr.split("/");
        char[][] cMap = Arrays.stream(inputStr.split("/")).map(v -> v.toCharArray()).toArray(char[][]::new);
        assertThat(solution.maximalRectangle(cMap)).isEqualTo(output);
    }



}