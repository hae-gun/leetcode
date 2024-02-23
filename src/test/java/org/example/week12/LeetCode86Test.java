package org.example.week12;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode86Test {
    LeetCode86 solution = new LeetCode86();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"10100/10111/11111/10010:6","0:0", "1:1"},delimiter = ':')
    void test(String inputStr, int output) {

    }



}