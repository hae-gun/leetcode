package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode40Test {
    LeetCode40 solution = new LeetCode40();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"10,1,2,7,6,1,5:8:1,1,6.1,2,5.1,7.2,6"
                            ,"2,5,2,1,2:5:1,2,2.5"}, delimiter = ':')
    void test(String candidates, int target, String result){
        List<List<Integer>> lists = solution.combinationSum2(Arrays.stream(candidates.split(",")).mapToInt(Integer::valueOf).toArray(), target);
        List<List<Integer>> resultList = Arrays.stream(result.split("\\."))
                .map(v -> Arrays.stream(v.split(",")).map(Integer::valueOf).toList())
                .toList();

        assertThat(lists).containsExactlyInAnyOrderElementsOf(resultList);

    }
}