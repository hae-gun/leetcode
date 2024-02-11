package org.example.week10;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode75Test {
    LeetCode75 solution = new LeetCode75();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2,0,2,1,1,0:0,0,1,1,2,2" ,
            "2,0,1:0,1,2"},delimiter = ':')
    void test(String numsStr, String outputStr) {
        int[] nums = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).toArray();
        int[] result = Arrays.stream(outputStr.split(",")).mapToInt(Integer::valueOf).toArray();
        solution.sortColors(nums);
        assertThat(nums).containsExactly(result);
    }
}
