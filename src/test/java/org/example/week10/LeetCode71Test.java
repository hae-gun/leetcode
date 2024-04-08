package org.example.week10;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode71Test {
    LeetCode71 solution = new LeetCode71();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"/home/:/home","/../:/","/home//foo:/home/foo","/a//b////c/d//././/..:/a/b/c"},delimiter = ':')
    void test(String input, String result){
        assertThat(solution.simplifyPath(input)).isEqualTo(result);
    }
}
