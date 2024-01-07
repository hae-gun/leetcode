package org.example.week5;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode37Test {
    LeetCode37 solution = new LeetCode37();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"53..7..../6..195.../.98....6./8...6...3/4..8.3..1/7...2...6/.6....28./...419..5/....8..79:534678912/672195348/198342567/859761423/426853791/713924856/961537284/287419635/345286179"}, delimiter = ':')
    void test(String mapStr, String answer){

        char [][] map = makeMap(mapStr);
        char[][] map2 = makeMap(answer);

        solution.solveSudoku(map);

        for (int i = 0; i < map.length; i++) {
            char[] chars = map[i];
            assertThat(chars).containsExactly(map2[i]);
        }
    }

    private char[][] makeMap(String mapStr){
        String[] lines = mapStr.split("/");
        char [][] map = new char[9][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            map[i] = line.toCharArray();
        }
        return map;
    }
}