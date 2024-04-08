package org.example.week3;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode26Test {
    LeetCode26 solution = new LeetCode26();

    @Test
    void test(){
        int[] arr = new int[]{1,1,2};
        int result = solution.removeDuplicates(arr);

        assertThat(result).isEqualTo(2);

        assertThat(Arrays.copyOf(arr, result)).containsExactly(1,2);
    }
}