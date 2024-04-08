package org.example.week10;

import org.example.week9.LeetCode68;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode69Test {
    LeetCode69 solution = new LeetCode69();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"4:2","8:2","1:1"},delimiter = ':')
    void test(int input, int result){
        assertThat(solution.mySqrt(input)).isEqualTo(result);
    }
}
