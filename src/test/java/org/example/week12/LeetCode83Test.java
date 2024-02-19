package org.example.week12;

import org.example.week2.ListNode;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode83Test {
    LeetCode83 solution = new LeetCode83();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,1,2:1,2","1,1,2,3,3:1,2,3"},delimiter = ':')
    void test(String input, String output) {

        List<Integer> nodeNums = new ArrayList<>(Arrays.stream(input.split(","))
                                .map(Integer::valueOf).toList());
        List<Integer> result= new ArrayList<>(Arrays.stream(output.split(",")).map(Integer::valueOf).toList());
        Collections.reverse(nodeNums);

        Collections.reverse(result);

        ListNode node = makeNode(nodeNums);
        ListNode resultNode = makeNode(result);

        assertThat(solution.deleteDuplicates(node).toString()).isEqualTo(resultNode.toString());
    }

    private ListNode makeNode(List<Integer> list){
        ListNode node = null;
        for(int i : list){
            if(node == null){
                node = new ListNode(i);
                continue;
            }
            node = new ListNode(i, node);
        }
        return node;
    }

}