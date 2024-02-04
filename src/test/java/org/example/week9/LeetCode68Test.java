package org.example.week9;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode68Test {


    LeetCode68 solution = new LeetCode68();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"This,is,an,example,of,text,justification.:16:This    is    an,example  of text,justification.",
    "What,must,be,acknowledgment,shall,be:16:What   must   be,acknowledgment  ,shall be",
    "Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do:20:Science  is  what we,understand      well,enough to explain to,a  computer.  Art is,everything  else  we,do                  "},delimiter = ':')
    void test(String words, int maxWidth, String resultStr){

        String[] wordsArr = words.split(",");
        String[] resultsArr = resultStr.split(",");
        assertThat(solution.fullJustify(wordsArr, maxWidth)).containsExactly(resultsArr);
    }
}
