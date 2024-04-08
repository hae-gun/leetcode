package org.example.week6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode43Test {
    LeetCode43 solution = new LeetCode43();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"2:3:6", "123:456:56088"}, delimiter = ':')
    void test(String num1, String num2, String result){
        assertThat(solution.multiply(num1, num2)).isEqualTo(result);
    }
}
