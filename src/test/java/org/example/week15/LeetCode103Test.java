package org.example.week15;

import org.example.week13.TreeNode;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCode103Test {

    LeetCode103 solution = new LeetCode103();
    @ParameterizedTest(name = "{index} {displayName} s={0}, output={1}")
    @CsvSource(value = {"3,9,20,null,null,15,7:[3],[20,9],[15,7]","1:[1]",":[]"},delimiter = ':')
    void test(String nodes , String resultStr){
        if(nodes == null) nodes = "";

        String[] arrs = resultStr.substring(1, resultStr.length()-1).split("\\]\\,\\[");
        List<List<Integer>> result = new ArrayList<>();
        for (String arr : arrs) {
            if("".equals(arr))continue;
            result.add(Arrays.stream(arr.split(",")).map(Integer::parseInt).toList());
        }

        TreeNode root = null;
        List<String> list = Arrays.stream(nodes.split(",")).toList();
        if(!"".equals(nodes)){
            root = createTree(list, 0);
        }

        List<List<Integer>> resultOfSolution = solution.zigzagLevelOrder(root);

        assertThat(resultOfSolution).containsExactlyElementsOf(result);

    }

    private TreeNode createTree(List<String> list, int index) {
        TreeNode root = null;

        // 인덱스가 배열 길이를 초과하거나 값이 null인 경우 종료
        if (index < list.size() && list.get(index) != null) {
            String value = list.get(index);
            if("null".equals(value)){
                return null;
            }
            root = new TreeNode(Integer.parseInt(value));
            root.left = createTree(list, 2 * index + 1); // 왼쪽 자식 노드 생성
            root.right = createTree(list, 2 * index + 2); // 오른쪽 자식 노드 생성
        }
        return root;
    }
}