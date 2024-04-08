package org.example.week7;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode49Test {
    //Example 1:
    //
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //Example 2:
    //
    //Input: strs = [""]
    //Output: [[""]]
    //Example 3:
    //
    //Input: strs = ["a"]
    //Output: [["a"]]
    LeetCode49 solution = new LeetCode49();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\":[\"bat\"],[\"nat\",\"tan\"].[\"ate\",\"eat\",\"tea\"]","\"\":[\"\"]", "\"a\":[\"a\"]"}, delimiter = ':')
    void test(String input, String resultStr){

        String[] arr = input.replaceAll("\\\\\"", "")
                        .split(",");
        List<List<String>> result = Arrays.stream(resultStr.replaceAll("\\\\\"", "")
                .replaceAll("\\[","").replaceAll("\\]","")
                        .split(".")).map(v -> Arrays.stream(v.split(",")).collect(Collectors.toList()))
                        .collect(Collectors.toList());
        assertThat(solution.groupAnagrams(arr)).containsExactlyElementsOf(result);
    }


}
