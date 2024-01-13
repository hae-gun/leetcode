package org.example.week6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode46Test {
    //Example 1:
    //
    //Input: nums = [1,2,3]
    //Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //Example 2:
    //
    //Input: nums = [0,1]
    //Output: [[0,1],[1,0]]
    //Example 3:
    //
    //Input: nums = [1]
    //Output: [[1]]
    LeetCode46 solution = new LeetCode46();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,3:[1,2,3].[1,3,2].[2,1,3].[2,3,1].[3,1,2].[3,2,1]","0,1:[0,1].[1,0]" ,"1,[1]"}, delimiter = ':')
    void test(String numStr, String result){
        int[] nums = Arrays.stream(numStr.split(",")).mapToInt(Integer::valueOf).toArray();

        String[] resListStr = result.split("\\.");

        List<List<Integer>> resultList = Arrays.stream(resListStr)
                .map(v -> v.replaceAll("\\[", "").replaceAll("\\]",""))
                .map(v -> v.split(","))
                .map( v -> Arrays.stream(v).mapToInt(Integer::valueOf).boxed().toList())
                .collect(Collectors.toList());

        assertThat(solution.permute(nums)).isEqualTo(resultList);
    }
}
