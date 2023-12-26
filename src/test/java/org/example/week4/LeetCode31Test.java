package org.example.week4;

import org.example.week3.LeetCode35;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode31Test {
    LeetCode31 solution = new LeetCode31();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,3:1,3,2",
                        "3,2,1:1,2,3",
                        "1,1,5:1,5,1"
                        }, delimiter = ':')
    void test(String numsStr, String ansStr){
        int[] nums = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).toArray();
        int[] answers = Arrays.stream(ansStr.split(",")).mapToInt(Integer::valueOf).toArray();

        solution.nextPermutation(nums);
        assertThat(nums).containsExactly(answers);

    }
}