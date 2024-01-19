package org.example.week7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeetCode54Test {
    LeetCode54 solution = new LeetCode54();
    //Input: matrix = [[1,2,3].[4,5,6].[7,8,9]]
    //Output: [1,2,3,6,9,8,7,4,5]

//    Input: matrix = [[1,2,3,4].[5,6,7,8].[9,10,11,12]]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[1,2,3].[4,5,6].[7,8,9]:1,2,3,6,9,8,7,4,5", "[1,2,3,4].[5,6,7,8].[9,10,11,12]:1,2,3,4,8,12,11,10,9,5,6,7"}, delimiter = ':')
    void test(String input, String resultStr){


        int[][] matrix = Arrays.stream(input.replaceAll("\\[", "").replaceAll("\\]", "").split("\\."))
                            .map(v -> Arrays.stream(v.split(",")).mapToInt(Integer::valueOf).toArray())
                            .toArray(int[][]::new);
        List<Integer> result = Arrays.stream(resultStr.split(","))
                                .map(Integer::valueOf).collect(Collectors.toList());

        assertThat(solution.spiralOrder(matrix)).isEqualTo(result);
    }


}
