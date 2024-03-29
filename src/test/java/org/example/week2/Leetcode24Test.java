package org.example.week2;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Leetcode24Test {
    LeetCode24 solution = new LeetCode24();

    @Test
    void test(){
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        first = solution.swapPairs(first);

        assertThat(first.toString()).isEqualTo(List.of(2,1,4,3).toString());
    }
}