package org.example.week9;

import org.example.week2.ListNode;
import org.example.week8.LeetCode61;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode62Test {
    LeetCode62 solution = new LeetCode62();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"3:7:28","3:2:3"}, delimiter = ':')
    void test(int m, int n, int result){
        assertThat(solution.uniquePaths(m,n)).isEqualTo(result);
    }
}
