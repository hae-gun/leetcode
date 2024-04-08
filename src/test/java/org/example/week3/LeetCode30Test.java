package org.example.week3;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode30Test {
    LeetCode30 solution = new LeetCode30();

    @Test
    void test(){
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","word"};
        List<Integer> result = solution.findSubstring(s, words);
//        assertThat(result).containsExactly(0, 9);
    }
}