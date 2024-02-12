package org.example.week11;

import org.example.week10.LeetCode75;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LeetCode76Test {

    LeetCode76 solution = new LeetCode76();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"ADOBECODEBANC:ABC:BANC" ,
            "a:a:a", "a:aa:"},delimiter = ':')
    void test(String input, String targetStr, String result) {
        if(result == null) result = "";
        assertThat(solution.minWindow(input, targetStr)).isEqualTo(result);
    }
}