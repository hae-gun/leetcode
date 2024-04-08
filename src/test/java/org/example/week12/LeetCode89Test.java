package org.example.week12;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LeetCode89Test {
    LeetCode89 solution = new LeetCode89();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2:0,1,3,2" , "1:0,1"},delimiter = ':')
    void test(int n, String numsStr) {
        List<Integer> result = Arrays.stream(numsStr.split(",")).mapToInt(Integer::valueOf).boxed().toList();
        assertThat(solution.grayCode(n)).containsExactlyElementsOf(result);
    }



}