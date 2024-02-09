package org.example.week10;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode73Test {
    LeetCode73 solution = new LeetCode73();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[1,1,1].[1,0,1].[1,1,1]]:[[1,0,1].[0,0,0].[1,0,1]]" ,
            "[[0,1,2,0].[3,4,5,2].[1,3,1,5]]:[[0,0,0,0].[0,4,5,0].[0,3,1,0]]"},delimiter = ':')
    void test(String inputArrStr, String resultArrStr){

        int[][] inputArr = Main.make2DArray(inputArrStr);
        solution.setZeroes(inputArr);

        List<List<Integer>> solutionResultList = makeArrToList(inputArr);
        List<List<Integer>> inputResultList = makeArrToList(Main.make2DArray(resultArrStr));


        assertThat(solutionResultList).containsExactlyElementsOf(inputResultList);;
    }


    List<List<Integer>> makeArrToList(int[][] arr){
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
