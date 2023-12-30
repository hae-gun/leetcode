package org.example.week4;

import org.example.week2.ListNode;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode25Test {
    LeetCode25 solution = new LeetCode25();

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,3,4,5:2:2,1,4,3,5"}, delimiter = ':')
    void test(String list, String k, String result){

        List<Integer> nodeNum = Arrays.stream(list.split(","))
                                .map(Integer::valueOf).collect(Collectors.toList());

        Collections.reverse(nodeNum);

        ListNode first = new ListNode(nodeNum.get(0));
        for(int i=1; i<nodeNum.size(); i++){
            first = new ListNode(nodeNum.get(i), first);
        }
        System.out.println(first);
        ListNode resultNode = solution.reverseKGroup(first, Integer.valueOf(k));
        List<Integer> collect = Arrays.stream(result.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        assertThat(resultNode.toString()).isEqualTo(collect.toString());
    }
}