package org.example.week12;

import org.example.week2.ListNode;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode84Test {
    LeetCode84 solution = new LeetCode84();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2,1,5,6,2,3:10","2,4:4"},delimiter = ':')
    void test(String inputStr, int output) {
        int[] input = Arrays.stream(inputStr.split(",")).mapToInt(Integer::valueOf).toArray();
        assertThat(solution.largestRectangleArea(input)).isEqualTo(output);
    }



}