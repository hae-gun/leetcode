package org.example.week6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode45Test {
    LeetCode45 solution = new LeetCode45();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2,3,1,1,4:2","2,3,0,1,4:2"}, delimiter = ':')
    void test(String numStr, int result){
        int[] nums = Arrays.stream(numStr.split(",")).mapToInt(Integer::valueOf).toArray();
        assertThat(solution.jump(nums)).isEqualTo(result);
    }
}
