package org.example.week5;

import org.example.week3.LeetCode35;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode36Test {
    LeetCode36 solution = new LeetCode36();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"53..7..../6..195.../.98....6./8...6...3/4..8.3..1/7...2...6/.6....28./...419..5/....8..79:true",
    "83..7..../6..195.../.98....6./8...6...3/4..8.3..1/7...2...6/.6....28./...419..5/....8..79:false"}, delimiter = ':')
    void test(String mapStr, boolean result){

        String[] lines = mapStr.split("/");
        char [][] map = new char[9][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            map[i] = line.toCharArray();
        }



        assertThat(solution.isValidSudoku(map)).isEqualTo(result);

//      assertThat(solution.searchRange(nums, target)).containsExactly(ans);

    }
}