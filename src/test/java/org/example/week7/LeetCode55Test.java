package org.example.week7;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeetCode55Test {
    LeetCode55 solution = new LeetCode55();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2,3,1,1,4:true" , "3,2,1,0,4:false"}, delimiter = ':')
    void test(String inputStr, boolean result){
        int[] nums = Arrays.stream(inputStr.split(","))
                            .mapToInt(Integer::valueOf).toArray();
        assertThat(solution.canJump(nums)).isEqualTo(result);
    }
}
