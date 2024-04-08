package org.example.week13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;
class LeetCode91Test {

    LeetCode91 solution = new LeetCode91();

    @ParameterizedTest(name = "{index} {displayName} s={0}, output={1}")
    @CsvSource(value = {"12:2","226:3","06:0"},delimiter = ':')
    void numDecodingTest(String s, int output){
        assertThat(solution.numDecodings(s)).isEqualTo(output);
    }
}