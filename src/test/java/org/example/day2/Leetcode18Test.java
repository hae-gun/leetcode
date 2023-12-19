package org.example.day2;

import org.example.day1.Leetcode11;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Leetcode18Test {
    LeetCode18 solution = new LeetCode18();

    @Test
    void test(){
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(-2,-1,1,2));
        result.add(List.of(-2,0,0,2));
        result.add(List.of(-1,0,0,1));
        assertThat(lists).hasSameElementsAs(result);
    }
}