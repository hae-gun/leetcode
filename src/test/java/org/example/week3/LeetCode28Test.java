package org.example.week3;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode28Test {
    LeetCode28 solution = new LeetCode28();

    @Test
    void test(){
        String haystack = "sadbutsad", needle = "sad";
        int result = solution.strStr(haystack, needle);
        assertThat(result).isEqualTo(0);
    }
}