package org.example.week6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode42Test {
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    //Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    //Example 2:
    //
    //Input: height = [4,2,0,3,2,5]
    //Output: 9
    LeetCode42 solution = new LeetCode42();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"0,1,0,2,1,0,1,3,2,1,2,1:6", "4,2,0,3,2,5:9"}, delimiter = ':')
    void test(String numsStr, int result){
        int[] nums = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).toArray();
        assertThat(solution.trap(nums)).isEqualTo(result);
    }
}
