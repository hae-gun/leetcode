package org.example.day3;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode27Test {
    LeetCode27 solution = new LeetCode27();

    @Test
    void test(){
        int[] arr = new int[]{3,2,2,3};
        int result = solution.removeElement(arr, 3);

        assertThat(result).isEqualTo(5);

        assertThat(Arrays.copyOf(arr, result)).containsExactly(0,1,4,0,3);
    }
}