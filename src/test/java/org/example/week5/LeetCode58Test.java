package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode58Test {
    LeetCode58 solution = new LeetCode58();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"Hello World:5", "   fly me   to   the moon  :4","luffy is still joyboy:6"}, delimiter = ':')
    void test(String word, int result){

        assertThat(solution.lengthOfLastWord(word)).isEqualTo(result);

    }
}