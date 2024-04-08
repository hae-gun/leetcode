package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode39Test {
    //nput: candidates = [2,3,6,7], target = 7
    //Output: [[2,2,3],[7]]
    //Explanation:
    //2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    //7 is a candidate, and 7 = 7.
    //These are the only two combinations.
    //Example 2:
    //
    //Input: candidates = [2,3,5], target = 8
    //Output: [[2,2,2,2],[2,3,3],[3,5]]
    //Example 3:
    //
    //Input: candidates = [2], target = 1
    //Output: []
    LeetCode39 solution = new LeetCode39();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2,3,6,7:7:2.2.3,7",
                        "2,3,5:8:2.2.2.2,2.3.3,3.5",
                        "2:1:0"}, delimiter = ':')
    void test(String list, int target, String results){
        int[] candiates = Arrays.stream(list.split(",")).mapToInt(Integer::valueOf).toArray();

        List<List<Integer>> result = Arrays.stream(results.split(","))
                .map(v -> Arrays.stream(v.split("\\.")).map(Integer::valueOf).collect(Collectors.toList()))
                .toList();
        List<List<Integer>> lists = solution.combinationSum(candiates, target);
        for (int i = 0; i < lists.size(); i++) {
            assertThat(lists.get(i)).containsExactlyElementsOf(result.get(i));
        }
    }
}