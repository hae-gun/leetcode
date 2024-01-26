package org.example.week8;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode60Test {
    LeetCode60 solution = new LeetCode60();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"3:3:213","4:9:2314", "3:1:123"}, delimiter = ':')
    void test(int n, int k, String result){
        assertThat(solution.getPermutation(n,k)).isEqualTo(result);
    }
}
