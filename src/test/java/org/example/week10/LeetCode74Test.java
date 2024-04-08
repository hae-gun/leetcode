package org.example.week10;

import org.example.Main;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode74Test {
    LeetCode74 solution = new LeetCode74();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"[[1,3,5,7],[10,11,16,20],[23,30,34,60]]:3:true" ,
            "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]:13:false"},delimiter = ':')
    void test(String inputArrStr, int target, boolean result){
        int[][] matrix = Main.make2DArray(inputArrStr);
        assertThat(solution.searchMatrix(matrix, target)).isEqualTo(result);
    }



}
