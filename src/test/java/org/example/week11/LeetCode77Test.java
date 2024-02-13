package org.example.week11;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode77Test {

    LeetCode77 solution = new LeetCode77();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"4:2:[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]", "1:1:[[1]]"},delimiter = ':')
    void test(int n, int k, String result) {

        int[][] ints = Main.make2DArray(result);

        List<List<Integer>> resultList = new ArrayList<>();

        for(int[] arr : ints){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            resultList.add(list);
        }

        List<List<Integer>> combines = solution.combine(n, k);
        assertThat(combines).containsExactlyElementsOf(resultList);

    }
}