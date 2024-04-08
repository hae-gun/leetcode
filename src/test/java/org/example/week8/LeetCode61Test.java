package org.example.week8;

import org.example.week2.ListNode;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode61Test {
    LeetCode61 solution = new LeetCode61();
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = {"1,2,3,4,5:2:4,5,1,2,3","0,1,2:4:2,0,1"}, delimiter = ':')
    void test(String ns, int k, String result){

        List<Integer> nss = Arrays.stream(ns.split(",")).map(Integer::valueOf).toList();
        List<Integer> resultS = Arrays.stream(result.split(",")).map(Integer::valueOf).toList();


        ListNode node1 = new ListNode(nss.get(nss.size()-1));
        for (int i = nss.size()-2; i >= 0; i--) {
            node1 = new ListNode( nss.get(i), node1) ;
        }
        ListNode node2 = new ListNode(resultS.get(resultS.size()-1));
        for (int i = resultS.size()-2; i >= 0; i--) {
            node2 = new ListNode( resultS.get(i), node2) ;
        }
        assertThat(solution.rotateRight(node1, k).toString()).isEqualTo(node2.toString());
    }
}
