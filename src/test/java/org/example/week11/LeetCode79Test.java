package org.example.week11;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode79Test {
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    //Output: true
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    //Output: true
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//    Output: false
    LeetCode79 solution = new LeetCode79();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"ABCE.SFCS.ADEE:ABCCED:true",
                        "ABCE.SFCS.ADEE:SEE:true",
                        "ABCE.SFCS.ADEE:ABCB:false", "a.a:aaa:false",
                        "ABCE.SFES.ADEE:ABCESEEEFS:true"},delimiter = ':')
    void test(String mapStr,  String target, boolean result) {
        char[][] board = Arrays.stream(mapStr.split("\\.")).map(String::toCharArray).toArray(char[][]::new);
        assertThat(solution.exist(board, target)).isEqualTo(result);
    }
    // A  B  C  E
    // S  F  E  S
    // A  D  E  E
}