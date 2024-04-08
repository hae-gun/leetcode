package org.example.week7;

import org.example.week6.LeetCode47;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode48Test {
    //Input: matrix = [[1,2,3].[4,5,6].[7,8,9]]
    //Output: [[7,4,1].[8,5,2].[9,6,3]]
//    Input: matrix = [[5,1,9,11].[2,4,8,10].[13,3,6,7].[15,14,12,16]]
//    Output: [[15,13,2,5].[14,3,4,1].[12,6,8,9].[16,7,10,11]]
    LeetCode48 solution = new LeetCode48();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[1,2,3].[4,5,6].[7,8,9]]:[[7,4,1].[8,5,2].[9,6,3]]","[[5,1,9,11].[2,4,8,10].[13,3,6,7].[15,14,12,16]]:[[15,13,2,5].[14,3,4,1].[12,6,8,9].[16,7,10,11]]"}, delimiter = ':')
    void test(String bfMapStr, String ansMapStr){

        int[][] bfMap = makeMap(bfMapStr);
        int[][] ansMap = makeMap(ansMapStr);
        solution.rotate(bfMap);

        List<List<Integer>> bfMapList = Arrays.stream(bfMap).map(v -> Arrays.stream(v).boxed().toList()).toList();
        List<List<Integer>> ansMapList = Arrays.stream(ansMap).map(v -> Arrays.stream(v).boxed().toList()).toList();

        assertThat(bfMapList).containsExactlyElementsOf(ansMapList);
    }

    private int[][] makeMap(String bfMapStr) {
        return Arrays.stream(bfMapStr.replaceAll("\\[", "")
                .replaceAll("\\]", "").split("\\."))
                .map(v -> Arrays.stream(v.split(",")).mapToInt(Integer::valueOf).toArray())
                .toArray(int[][]::new);
    }
}
