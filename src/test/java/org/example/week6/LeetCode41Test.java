package org.example.week6;

import org.example.week5.LeetCode58;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode41Test {
    LeetCode41 solution = new LeetCode41();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,0:3", "3,4,-1,1:2","7,8,9,11,12:1"}, delimiter = ':')
    void test(String numsStr, int result){
        int[] nums = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).toArray();
        assertThat(solution.firstMissingPositive(nums)).isEqualTo(result);
    }
}
