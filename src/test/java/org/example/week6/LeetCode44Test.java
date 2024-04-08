package org.example.week6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode44Test {
    LeetCode44 solution = new LeetCode44();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"aa:a:false", "aa:*:true", "cb:?a:false"}, delimiter = ':')
    void test(String str, String pattern, boolean result){
        assertThat(solution.isMatch(str, pattern)).isEqualTo(result);
    }
}
