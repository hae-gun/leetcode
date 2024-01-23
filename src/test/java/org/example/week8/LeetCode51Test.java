package org.example.week8;

import org.example.Main;
import org.example.week7.LeetCode56;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode51Test {
    LeetCode51 solution = new LeetCode51();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"4:.Q.., ...Q, Q..., ..Q.|..Q., Q..., ...Q, .Q.." }, delimiter = ':')
    void test(String input, String resultsStr){
        List<List<String>> lists = solution.solveNQueens(Integer.parseInt(input));

        List<List<String>> result = Arrays.stream(resultsStr.split("\\|"))
                .map(v -> Arrays.stream(v.split(",")).map(String::trim).toList()).toList();

        assertThat(lists).containsExactlyElementsOf(result);
    }
}
