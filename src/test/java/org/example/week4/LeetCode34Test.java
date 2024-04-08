package org.example.week4;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode34Test {
    LeetCode34 solution = new LeetCode34();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"5,7,7,8,8,10:8:3,4", "5,7,7,8,8,10:6:-1,-1",  ":0:-1,-1"}, delimiter = ':')
    void test(String list, String targetStr, String ansStr){
        int[] nums;
        if(list == null){
            nums = new int[0];
        }else{
            nums = Arrays.stream(list.split(",")).mapToInt(Integer::valueOf).toArray();
        }
        int target = Integer.valueOf(targetStr);
        int[] ans = Arrays.stream(ansStr.split(",")).mapToInt(Integer::valueOf).toArray();

        assertThat(solution.searchRange(nums, target)).containsExactly(ans);

    }
}