package org.example.week11;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode78Test {
    LeetCode78 solution = new LeetCode78();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,3:[[-1],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]", "0:[[-1],[0]]"},delimiter = ':')
    void test(String inputArr,  String resultStr) {

        int nums[] = Arrays.stream(inputArr.split(",")).mapToInt(Integer::valueOf).toArray();

        int[][] result = Main.make2DArray(resultStr);

        result[0] = new int[0];

        List<List<Integer>> listOfLists = Arrays.stream(result)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        assertThat(solution.subsets(nums)).containsAnyElementsOf(listOfLists);

    }
}