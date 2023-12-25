package org.example.week3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
class LeetCode35Test {
    LeetCode35 solution = new LeetCode35();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,3,5,6:5:2",
                        "1,3,5,6:2:1",
                        "1,3,5,6:7:4"
                        }, delimiter = ':')
    void test(String numsStr, String targetStr, String expected){

        int[] nums = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).toArray();
        int target = Integer.valueOf(targetStr);

        int result = solution.searchInsert(nums, target);
        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }
}